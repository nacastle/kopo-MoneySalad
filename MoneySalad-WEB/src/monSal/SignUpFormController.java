package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpFormController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "/member/signUpForm.jsp"; // root는 Mission-WEB-MVC01 부터임
	}

}
