package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;

public class ListController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.selectAllBoard();
		
		request.setAttribute("boardList", boardList);
		
		
		
		
		return "/board/list.jsp"; // root는 Mission-WEB-MVC01 부터임
	}

}