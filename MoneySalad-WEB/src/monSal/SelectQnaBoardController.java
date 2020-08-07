package monSal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardFileVO;
import monSal.QnAboard.vo.BoardVO;
import monSal.transaction.dao.TransactionDAO;
import monSal.transaction.vo.TransactionVO;

public class SelectQnaBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		String boardNo = request.getParameter("no");
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		String block = request.getParameter("block");
		
		BoardDAO dao = new BoardDAO();
		if(type != null && type.equals("list")) {
			dao.incrementViewCnt(boardNo);
		}
		BoardVO board = dao.selectBoard(boardNo);
		List<BoardFileVO> fileList = dao.selectFileByNo(boardNo);
		
		
		request.setAttribute("page", page);
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		request.setAttribute("block", block);

		
		return "/qnaBoard/board.jsp";
	}

}
