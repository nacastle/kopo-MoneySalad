package monSal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;

public class SelectQnaBoardListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();

//		System.out.println("???"+request.getParameter("block"));
		int block = Integer.parseInt(request.getParameter("block")); // 나중에 다른 기능(ex.새글작성) 갔다가 목록으로 되돌아갈때 필요
//		int block = (int)request.getParameter("block");
		
		int page = Integer.parseInt(request.getParameter("page")); // block이랑 page는 그냥 받아서 넘겨줄거니까 좀 나중에 설명해도됨
		
		int totalBoard = dao.cntBoard(); // DB에 있는 전체 게시글 수
		int boardPerPage = 5; // 페이지당 게시글 수
		int totalPage = totalBoard / boardPerPage; // 전체 페이지 수
		if(totalBoard%boardPerPage > 0) {
			totalPage++; // 나머지가 있으면 페이지가 다 돌고 남은 게시글이 있는 것이기에 전체 페이지 수에 +1 해줌
//			int restBoard = totalBoard % boardPerPage;
		}
		
		int pagePerBlock = 3; // 블럭당 페이지 수
		int totalBlock = totalPage / pagePerBlock; // 블럭 수
		if(totalPage%pagePerBlock > 0) {  
//			if(totalPage%pagePerBlock != 10) {
			totalBlock++;  // 나머지가 있으면 블럭이 다 돌고 나서 남은 페이지가 있는 것이기에 전체 페이지 수에  +1 해줌
		}
		
		
		
		int blockStartPage = 1+pagePerBlock*(block-1); // 
		int blockEndPage = pagePerBlock*block;
//		int blockEndPage = blockStartPage+pagePerBlock-1;
		
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
