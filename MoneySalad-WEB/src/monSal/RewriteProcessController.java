package monSal;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardFileVO;
import monSal.QnAboard.vo.BoardVO;
import util.KopoFileNamePolicy;

public class RewriteProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");

		String saveFolder = "C:/Users/Na/Desktop/kopo_edu/MoneySalad/MoneySalad-WEB/WebContent/upload";  // save 할 경로

		MultipartRequest multi = new MultipartRequest(request, saveFolder, 
														1024 * 1024 * 3, "utf-8",
														new KopoFileNamePolicy()
														);  // KopoFileNamePolicy : 파일명 자동으로 바꿔줌


		BoardDAO dao = new BoardDAO();
		// 1단계 : 게시물 저장(t_board)
		String title = multi.getParameter("title");
		String id = multi.getParameter("writer");
//		System.out.println("id: " + id);
		String content = multi.getParameter("content");
		String parentNo = multi.getParameter("parentNo");
		int block = Integer.parseInt(multi.getParameter("block"));
		int page = Integer.parseInt(multi.getParameter("page"));

		
		BoardVO parentBoard = dao.selectBoard(parentNo);
		String originalNo = parentBoard.getOriginalNo();
//		System.out.println("부모번호" + parentNo);

		String boardNo = dao.selectBoardNo();
		request.setAttribute("no", boardNo); 

		// 게시물 번호 추출(seq_t_board_no)
		BoardVO childBoard = new BoardVO();

		childBoard.setTitle(title);
		childBoard.setId(id);
		childBoard.setContent(content);
		childBoard.setBoardNo(boardNo);
		childBoard.setOriginalNo(originalNo);
		childBoard.setParentNo(parentNo);

		dao.rewriteBoard(childBoard, parentBoard);
		
		System.out.println("getBoardNo(): " + parentBoard.getBoardNo());
		System.out.println("getOriginalNo(): " + parentBoard.getOriginalNo());
		
		
		if(parentBoard.getBoardNo() != parentBoard.getOriginalNo()) {
//			parentBoard.setParentNo(parentBoard.getBoardNo());
			dao.rewriteUpdateParent(parentBoard);
		}

		// 2단계 : 첨부파일 저장(t_board_file)
		Enumeration<String> files =  multi.getFileNames();
		while(files.hasMoreElements()) {
			String fileName = files.nextElement();
			File f = multi.getFile(fileName);
			if(f != null) {
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int)f.length();
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				fileVO.setBoardNo(boardNo);		// 외래키에 해당 게시물번호
				
				dao.insertFile(fileVO);
			}
		}
		
		
		request.setAttribute("url", request.getContextPath()+"/board.do?block="+block+"&page="+page+"&no="+boardNo);
		request.setAttribute("msg", "답글이 등록되었습니다.");
		
		
		
		return "/qnaBoard/rewriteProcess.jsp";
	}

}
