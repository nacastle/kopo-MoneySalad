package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RewriteFormController implements Controller{
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String boardNo = request.getParameter("no");
		int block = Integer.parseInt(request.getParameter("block"));
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("block", block);
		request.setAttribute("page", page);
		
		return "/qnaBoard/rewriteForm.jsp"; // write.do에서 write.jsp로 포워드 해줄거임...root는 Mission-WEB-MVC01 부터임
	}

}
