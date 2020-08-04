package monSal;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterAccountFormController implements Controller{
	
	Random r = new Random();

	public long genBalance() {
		long balance = (r.nextInt(99) + 1)*1000;
		return balance;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		long balance = genBalance();
		request.setAttribute("balance", balance);


		return "/account/registerAccountForm.jsp";
	}

}
