package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.Controller;
import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;

public class SelectTBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// 쉬운 부분부터..		
		int blockNo = Integer.parseInt(request.getParameter("blockNo"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		// 임의 설정이 필요한 부분
		int boardCntPerPage = 5;
		int pageCntPerBlock = 5;
		
		// 블록의 시작 페이지와 끝 페이지 (등차수열 적용)
		int blockStartPageNo = 1 + pageCntPerBlock * (blockNo - 1);
		int blockEndPageNo = pageCntPerBlock * blockNo;
		
		//// 전체 게시글 수 구하는 코드(dao로 db에 접근해서 cnt 얻어옴)
		BoardDAO dao = new BoardDAO();
		int totalBoardCnt = dao.cntBoard();
		
		//// 전체 페이지 수 구하는 코드
		int totalPageCnt = totalBoardCnt / boardCntPerPage;
		if(totalBoardCnt % boardCntPerPage > 0) {
			totalPageCnt++; // 나머지가 있으면 페이지가 다 돌고 남은 게시글이 있는 것이기에 전체 페이지 수에 +1 해줌
		}
		
		//// 만약 위 연산으로 계산한 해당 블록 끝 번호가 전체 페이지 번호 수 보다 크다면 블록 끝 번호는 전체 페이지 번호 수 (블록 끝 번호가 계속 전체 페이지 번호수보다 작다가 마지막에만 커지거나 같아짐)
		if (blockEndPageNo > totalPageCnt) {
			blockEndPageNo = totalPageCnt;
		}
		
		// 전체 블록 개수 구하기 (다음 버튼 기능을 구현해주기 위해)
		int totalBlockCnt = totalPageCnt / pageCntPerBlock;
		if (totalPageCnt % pageCntPerBlock > 0) {
			totalBlockCnt++;
			
		}
		
		
		
		// 해당 페이지에서 필요한만큼의 게시글 데이터 얻어오기 
		List<BoardVO> boardList = dao.selectPageBoard(pageNo, boardCntPerPage); // 이거  dao 설명 필요 (rownum)
		
		
		
		request.setAttribute("blockStartPageNo", blockStartPageNo);
		request.setAttribute("blockEndPageNo", blockEndPageNo);
		request.setAttribute("blockNo", blockNo);
		request.setAttribute("totalBlockCnt", totalBlockCnt);
		request.setAttribute("pageNo", pageNo);  
		
		request.setAttribute("boardList", boardList);

		
		
		
		//등록일 설정(오늘날짜면 시분초, 과거날짜면 년월일)
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		String javaSimpleDate = format.format(calendar.getTime());

		request.setAttribute("javaSimpleDate", javaSimpleDate);
		
		
		return "/test/tBoardList.jsp";
	}

}
