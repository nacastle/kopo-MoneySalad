package monSal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;
import monSal.transaction.dao.TransactionDAO;
import monSal.transaction.vo.TransactionVO;

public class SelectQnaBoardListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();

		int block = Integer.parseInt(request.getParameter("block"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		int boardCnt = dao.cntBoard();
		int boardPerPage = 5;
		int pagePerBlock = 5;
		
		int totalPage = boardCnt / boardPerPage;
		if(boardCnt%boardPerPage > 0) {
			totalPage++;
//			int restBoard = boardCnt % boardPerPage;
		}
		int blockCnt = totalPage / pagePerBlock;
		if(totalPage%pagePerBlock != 10) {
			blockCnt++;
		}
		
		
		
		int groupStartPage = 1+5*(block-1);
		int groupEndPage = groupStartPage+pagePerBlock-1;
		
		if(groupEndPage >totalPage ) {
			groupEndPage = totalPage;
		}
		
		request.setAttribute("groupStartPage", groupStartPage);
		request.setAttribute("groupEndPage", groupEndPage);
		request.setAttribute("block", block);
		request.setAttribute("blockCnt", blockCnt);
		request.setAttribute("page", page);
		
		
		
		List<BoardVO> boardList = dao.selectAllBoard(page,boardPerPage);
		
		request.setAttribute("boardList", boardList);

		//등록일 설정(오늘날짜면 시분초, 과거날짜면 년월일)
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		String javaSimpleDate = format.format(calendar.getTime());

		request.setAttribute("javaSimpleDate", javaSimpleDate);
		
		
		return "/qnaBoard/boardList.jsp";
	}

}
