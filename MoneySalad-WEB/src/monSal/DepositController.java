package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepositController implements Controller{
	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String accountNumber = request.getParameter("accountNumber");
		Long balance = Long.parseLong(request.getParameter("balance"));
		
		request.setAttribute("accountNumber", accountNumber);
		request.setAttribute("balance", balance);

		
		
		return "/account/deposit.jsp"; // root는 Mission-WEB-MVC01 부터임

	}
	
	
	
	

}
