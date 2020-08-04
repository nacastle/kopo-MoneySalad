package monSal;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;

public class DeleteBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String boardNo = request.getParameter("no");
		
		BoardDAO dao = new BoardDAO();
		
		dao.deleteBoard(boardNo);
		
		
		
		request.setAttribute("msg", "해당 게시글이 삭제되었습니다.");
		request.setAttribute("url", request.getContextPath()+"/qnaBoardList.do");
		
		return "/qnaBoard/deleteProcess.jsp";
	}

}
