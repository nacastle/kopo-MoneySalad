package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAccountFormController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "/account/deleteAccountForm.jsp"; // root는 Mission-WEB-MVC01 부터임
	}

	
	

}
