package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;
import monSal.transaction.dao.TransactionDAO;

public class DepositProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		String accountNumber = request.getParameter("accountNumber");
		long depositAmount = Long.parseLong(request.getParameter("depositAmount"));
		String name = ((LoginVO)session.getAttribute("userVO")).getName();
		
		TransactionDAO tDao = new TransactionDAO();
		tDao.recordDeposit(accountNumber, name, depositAmount); // 나성주
		
		AccountDAO dao = new AccountDAO();
		dao.depositDAO(accountNumber,depositAmount);
		
		
		
		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); //
		List<AccountVO> accountList = dao.selectAllAccountDAO(userVO);
		session.setAttribute("accountList", accountList);
		
		
		request.setAttribute("url", request.getContextPath()+"/depositForm.do");
		request.setAttribute("msg", "입금이 완료되었습니다.");
		
		
		
		
		return "/account/depositProcess.jsp"; // root는 Mission-WEB-MVC01 부터임

	}

}
