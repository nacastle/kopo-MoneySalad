package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;

public class TransferProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("utf-8");

		String msg = "";
		String url = "";
		
		AccountDAO dao = new AccountDAO();
		String accountNumber = request.getParameter("accountNumber");
		String receiveAccountNumber = request.getParameter("receiveAccountNumber");
		String bank = request.getParameter("selectBank");
		long transferAmount = Long.parseLong(request.getParameter("transferAmount"));
		
		AccountVO sendAccount = dao.selectAccountDAO(accountNumber);
		AccountVO receiveAccount = dao.selectAccountDAO(receiveAccountNumber, bank);
		String receiveId = receiveAccount.getId();
		System.out.println("상대계좌아이디:"+receiveAccount.getId());
		Long balance = sendAccount.getBalance();
		if(receiveId == null) {
//			String none = "none";
//			request.setAttribute("none", none);
			msg = "입력하신 계좌정보로 등록된 계좌가 존재하지 않습니다.";
			request.setAttribute("msg", msg);
			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("balance", balance );
			return "/account/transferProcess.jsp";
			
		}
		
		if(balance < transferAmount) {
			msg = "잔액이 모자릅니다.";
			url = request.getContextPath()+"/transfer.do";
//			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("balance", balance );
			return "/account/transferProcess.jsp";
		}
		dao.depositDAO(receiveAccountNumber, transferAmount );
		dao.withdrawDAO(accountNumber, transferAmount);
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); //
		List<AccountVO> accountList = dao.selectAllAccountDAO(userVO);
		session.setAttribute("accountList", accountList);
		
		
		request.setAttribute("url", request.getContextPath()+"/transferForm.do");
		request.setAttribute("msg", "송금이 완료되었습니다.");
		
		
		
		
		return "/account/transferProcess.jsp"; // root는 Mission-WEB-MVC01 부터임

	}

}
