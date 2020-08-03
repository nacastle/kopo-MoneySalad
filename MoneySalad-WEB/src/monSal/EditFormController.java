package monSal;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;

public class EditFormController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		String boardNo = request.getParameter("no");
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectBoard(boardNo);
		
		request.setAttribute("board", board);

		
		return "/qnaBoard/editForm.jsp";
	}


}
