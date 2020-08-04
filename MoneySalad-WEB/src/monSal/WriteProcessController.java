package monSal;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardFileVO;
import monSal.QnAboard.vo.BoardVO;
import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.dao.LoginDAO;
import monSal.login.vo.LoginVO;
import util.KopoFileNamePolicy;

public class WriteProcessController implements Controller {
	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");

		String saveFolder = "C:/Users/Na/Desktop/kopo_edu/MoneySalad/MoneySalad-WEB/WebContent/upload";  // save 할 경로

		MultipartRequest multi = new MultipartRequest(request, saveFolder, 
														1024 * 1024 * 3, "utf-8",
														new KopoFileNamePolicy()
														);  // KopoFileNamePolicy : 파일명 자동으로 바꿔줌


		// 1단계 : 게시물 저장(t_board)
		String title = multi.getParameter("title");
		String id = multi.getParameter("writer");
		String content = multi.getParameter("content");

		BoardDAO dao = new BoardDAO();
		String boardNo = dao.selectBoardNo();
		request.setAttribute("no", boardNo);

		// 게시물 번호 추출(seq_t_board_no)
		BoardVO board = new BoardVO();

		board.setTitle(title);
		board.setId(id);
		board.setContent(content);
		board.setBoardNo(boardNo);

		dao.insertBoard(board);

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
		
		
		request.setAttribute("url", request.getContextPath()+"/board.do?no="+boardNo);
		request.setAttribute("msg", "게시글이 등록되었습니다.");
		
		
		
		return "/qnaBoard/writeProcess.jsp";
	}
}
