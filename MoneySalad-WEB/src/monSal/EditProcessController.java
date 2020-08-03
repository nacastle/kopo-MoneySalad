package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;

public class EditProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("UTF-8");

		
		String boardNo = request.getParameter("boardNo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(boardNo);
		System.out.println(title);
		System.out.println(content);
		
		BoardVO board = new BoardVO();
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.editBoard(boardNo, board);
		
		request.setAttribute("url", request.getContextPath()+"/board.do?no="+boardNo);
		request.setAttribute("msg", "게시글 수정이 완료되었습니다.");
		
		
		

		
		return "/qnaBoard/editProcess.jsp";

	}
}
