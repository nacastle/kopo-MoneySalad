package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;
import monSal.transaction.dao.TransactionDAO;

public class RegisterAccountProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
	request.setCharacterEncoding("utf-8");
	
	AccountVO accountVO = new AccountVO(); 
	
	
	
	HttpSession session = request.getSession(); // 세션 객체 얻기
	
	LoginVO userVO = (LoginVO)session.getAttribute("userVO"); //
	String id = userVO.getId();
	String accountOwner = userVO.getName(); //db t_account테이블엔 이 속성 없음
	String bank = request.getParameter("selectBank");
	String accountNumber = request.getParameter("accountNumber"); 
	String nickname = request.getParameter("nickname");
	Long balance = Long.parseLong(request.getParameter("balance"));
	
	accountVO.setId(id);
	accountVO.setAccountOwner(accountOwner);
	accountVO.setBank(bank);
	accountVO.setAccountNumber(accountNumber);
	accountVO.setNickname(nickname);
	accountVO.setBalance(balance);
	

	
	AccountDAO dao = new AccountDAO();
	dao.registerAccountDAO(accountVO);
	
	TransactionDAO tDao = new TransactionDAO();
	tDao.recordRegister(accountNumber, bank + " 계좌 등록", balance); 

	List<AccountVO> accountList = dao.selectAllAccountDAO(userVO);
	session.setAttribute("accountList", accountList);
	
	request.setAttribute("url", request.getContextPath());
	request.setAttribute("msg", "계좌가 등록되었습니다.");
	
	
	
	return "/account/registerAccountProcess.jsp";
}

}
