package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "/qnaBoard/writeForm.jsp"; // write.do에서 write.jsp로 포워드 해줄거임...root는 Mission-WEB-MVC01 부터임
	}

}
