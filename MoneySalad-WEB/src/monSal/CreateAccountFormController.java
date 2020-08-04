package monSal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.QnAboard.dao.BoardDAO;
import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;

public class CreateAccountFormController implements Controller {

	Random r = new Random();

	public String genNewAccountNumber() {

		int firstAccountNumber = r.nextInt(100) + 700;
		int secondAccountNumber = r.nextInt(10000) + 70000;
		int thirdAccountNumber = r.nextInt(1000) + 7000;
		String newAccountNumber = firstAccountNumber + "-" + secondAccountNumber + "-" + thirdAccountNumber;

		return newAccountNumber;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		List<String> accountNumberList = new ArrayList<>();
		AccountDAO dao = new AccountDAO();

		accountNumberList = dao.selectAllAccountNumberDAO();

		String newAccountNumber = null;
		
		while (true) {

			newAccountNumber = genNewAccountNumber();
			System.out.println(newAccountNumber);
			if (accountNumberList.contains(newAccountNumber)) {
				newAccountNumber = genNewAccountNumber();
			} else {
				break;
			}
		}


		request.setAttribute("newAccountNumber", newAccountNumber);

		return "/account/createAccountForm.jsp";
	}
}
