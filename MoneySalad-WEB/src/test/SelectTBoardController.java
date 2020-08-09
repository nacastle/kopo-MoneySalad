package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.Controller;
import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardFileVO;
import monSal.QnAboard.vo.BoardVO;

public class SelectTBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		String no = request.getParameter("no");
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo");
		String blockNo = request.getParameter("blockNo");
		
		BoardDAO dao = new BoardDAO();
		if(type != null && type.equals("list")) {
			dao.incrementViewCnt(no);
		}
		BoardVO board = dao.selectBoard(no);
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("blockNo", blockNo);

		
		return "/test/tBoard.jsp";
	}

}
