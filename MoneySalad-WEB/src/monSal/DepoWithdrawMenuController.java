package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepoWithdrawMenuController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/account/depoWithdrawMenu.jsp"; // root는 Mission-WEB-MVC01 부터임

	}

}
