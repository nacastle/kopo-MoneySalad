package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;

public class DeleteAccountProcessController implements Controller{
	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String accountNumber = request.getParameter("accountNumber");
		
		AccountDAO dao = new AccountDAO();
		dao.deleteAccountDAO(accountNumber);
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); //
		List<AccountVO> accountList = dao.selectAllAccountDAO(userVO);
		session.setAttribute("accountList", accountList);
		
		request.setAttribute("url", request.getContextPath()+"/deleteAccountForm.do");
		request.setAttribute("msg", "해당 계좌가 삭제되었습니다.");
		
		
		return "/account/deleteAccountProcess.jsp"; // root는 Mission-WEB-MVC01 부터임
	}


}
