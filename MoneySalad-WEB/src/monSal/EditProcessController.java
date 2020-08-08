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

public class EditProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("UTF-8");
		
		String saveFolder = "C:/Users/Na/Desktop/kopo_edu/MoneySalad/MoneySalad-WEB/WebContent/upload";  // save 할 경로

		MultipartRequest multi = new MultipartRequest(request, saveFolder, 
														1024 * 1024 * 3, "utf-8",
														new KopoFileNamePolicy()
														);  // KopoFileNamePolicy : 파일명 자동으로 바꿔줌


		// 1단계 : 게시물 저장(t_board)
		String boardNo = multi.getParameter("boardNo");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		int block = Integer.parseInt(multi.getParameter("block"));
		int page = Integer.parseInt(multi.getParameter("page"));

		

		BoardVO board = new BoardVO();
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.editBoard( board);
		
		

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
		
	
		//////////여기부터 옛날거////////////////////////////////////////////////////////
		
		
//		String boardNo = request.getParameter("boardNo");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		
//		System.out.println(boardNo);
//		System.out.println(title);
//		System.out.println(content);
//		
//		BoardVO board = new BoardVO();
//		board.setBoardNo(boardNo);
//		board.setTitle(title);
//		board.setContent(content);
//		
//		BoardDAO dao = new BoardDAO();
//		dao.editBoard(boardNo, board);
		
		request.setAttribute("url", request.getContextPath()+"/board.do?block="+block+"&page="+page+"&no="+boardNo);
		request.setAttribute("msg", "게시글 수정이 완료되었습니다.");
		
		
		

		
		return "/qnaBoard/editProcess.jsp";

	}
}
