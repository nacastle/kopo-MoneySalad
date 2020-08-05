package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;

public class WithdrawProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AccountDAO dao = new AccountDAO();
		String accountNumber = request.getParameter("accountNumber");
		long withdrawAmount = Long.parseLong(request.getParameter("withdrawAmount"));
		
		AccountVO account = dao.selectAccountDAO(accountNumber);
		Long balance = account.getBalance();
		
		String msg = "";
		String url = "";
		if(balance < withdrawAmount) {
			msg = "잔액이 모자릅니다.";
			url = request.getContextPath()+"/withdraw.do";
//			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("balance", balance);
			return "/account/withdrawProcess.jsp";
		}
		
		dao.withdrawDAO(accountNumber, withdrawAmount);
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); //
		List<AccountVO> accountList = dao.selectAllAccountDAO(userVO);
		session.setAttribute("accountList", accountList);
		
		
		request.setAttribute("url", request.getContextPath()+"/withdrawForm.do");
		request.setAttribute("msg", "출금이 완료되었습니다.");
		
		
		
		
		return "/account/withdrawProcess.jsp"; // root는 Mission-WEB-MVC01 부터임

	}

}
