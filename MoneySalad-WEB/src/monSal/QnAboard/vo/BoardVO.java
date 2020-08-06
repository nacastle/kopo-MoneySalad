package monSal.QnAboard.vo;

public class BoardVO {
	
	private String boardNo;
	private String title;
	private String content;
	private String id;
	private int viewCnt;
	private String regDate;
	private String originalNo;
	private String parentNo;
	private int boardDepth;
	
	
	
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public BoardVO(String boardNo, String title, String content, String id, int viewCnt, String regDate,
			String originalNo, String parentNo, int boardDepth) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.id = id;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
		this.originalNo = originalNo;
		this.parentNo = parentNo;
		this.boardDepth = boardDepth;
	}



	public String getParentNo() {
		return parentNo;
	}




	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}




	public int getBoardDepth() {
		return boardDepth;
	}

	public void setBoardDepth(int boardDepth) {
		this.boardDepth = boardDepth;
	}


	public String getOriginalNo() {
		return originalNo;
	}
	
	public void setOriginalNo(String originalNo) {
		this.originalNo = originalNo;
	}



	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	
	
	
	
	
	
	
	

}
