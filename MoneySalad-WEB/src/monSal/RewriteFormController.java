package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RewriteFormController implements Controller{
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String boardNo = request.getParameter("no");
		request.setAttribute("boardNo", boardNo);
		
		return "/qnaBoard/rewriteForm.jsp"; // write.do에서 write.jsp로 포워드 해줄거임...root는 Mission-WEB-MVC01 부터임
	}

}
