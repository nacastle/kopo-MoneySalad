package monSal;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;

public class EditFormController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String boardNo = request.getParameter("no");
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectBoard(boardNo);
		String title = board.getTitle();
		String content = board.getContent();
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("title", title);
		request.setAttribute("content", content);

		
		
	
		
		return "/qnaBoard/editForm.jsp";
	}


}
