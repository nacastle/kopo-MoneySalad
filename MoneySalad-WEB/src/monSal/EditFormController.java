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
		int block = Integer.parseInt(request.getParameter("block"));
		int page = Integer.parseInt(request.getParameter("page"));

		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectBoard(boardNo);
		String title = board.getTitle();
		String content = board.getContent();
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("block", block);
		request.setAttribute("page", page);

		
		
	
		
		return "/qnaBoard/editForm.jsp";
	}


}
