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

//		System.out.println("???"+request.getParameter("block"));
		int block = Integer.parseInt(request.getParameter("block"));
//		int block = (int)request.getParameter("block");
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		int totalBoard = dao.cntBoard(); // DB에 있는 전체 게시글 수
		int boardPerPage = 7; // 페이지당 게시글 수
		int pagePerBlock = 5; // 블럭당 페이지 수
		
		int totalPage = totalBoard / boardPerPage; // 전체 페이지 수
		if(totalBoard%boardPerPage > 0) {
			totalPage++; // 나머지가 있으면 페이지가 다 돌고 남은 게시글이 있는 것이기에 전체 페이지 수에 +1 해줌
//			int restBoard = totalBoard % boardPerPage;
		}
		int totalBlock = totalPage / pagePerBlock; // 블럭 수
		if(totalPage%pagePerBlock > 0) {  
//			if(totalPage%pagePerBlock != 10) {
			totalBlock++;  // 나머지가 있으면 블럭이 다 돌고 나서 남은 페이지가 있는 것이기에 전체 페이지 수에  +1 해줌
		}
		
		
		
		int blockStartPage = 1+pagePerBlock*(block-1); // 
		int blockEndPage = blockStartPage+pagePerBlock-1;
		
		if(blockEndPage > totalPage ) {
			blockEndPage = totalPage;
		}
		
		request.setAttribute("blockStartPage", blockStartPage);
		request.setAttribute("blockEndPage", blockEndPage);
		request.setAttribute("block", block);
		request.setAttribute("totalBlock", totalBlock);
		request.setAttribute("page", page);  
		
		
		
		List<BoardVO> boardList = dao.selectPageBoard(page, boardPerPage); // 해당 페이지에 들어갈 board 리스트
		
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
