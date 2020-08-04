package monSal;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;

public class CreateAccountProcessController implements Controller {
	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		
		AccountVO accountVO = new AccountVO(); 
		
		
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		
		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); //
		String id = userVO.getId();
		String accountOwner = userVO.getName(); //db t_account테이블엔 이 속성 없음
		String bank = "캐슬은행";
		String newAccountNumber = request.getParameter("newAccountNumber"); 
		String nickname = request.getParameter("nickname");
		int depositAmount = Integer.parseInt(request.getParameter("depositAmount"));
		
		accountVO.setId(id);
		accountVO.setAccountOwner(accountOwner);
		accountVO.setBank(bank);
		accountVO.setAccountNumber(newAccountNumber);
		accountVO.setNickname(nickname);
		accountVO.setBalance(depositAmount);
		
		AccountDAO dao = new AccountDAO();
		dao.registerAccountDAO(accountVO);

		List<AccountVO> accountList = dao.selectAllAccountDAO(userVO);
		session.setAttribute("accountList", accountList);
		
		request.setAttribute("url", request.getContextPath());
		request.setAttribute("msg", "새로운 계좌가 생성되었습니다.");
		
		
		
		return "/account/createAccountProcess.jsp";
	}

}
