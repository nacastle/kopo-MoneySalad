package monSal.QnAboard.dao;

import java.util.ArrayList;
import java.util.List;

import monSal.QnAboard.vo.BoardVO;

public class BoardDAO {
	
	public List<BoardVO> selectAllBoard(){
		
		List<BoardVO> boardList = new ArrayList<>();
		
		boardList.add(new BoardVO("aaa","bbb"));
		boardList.add(new BoardVO("ccc","ddd"));
		
		
		
		return boardList;
	}

}
