package monSal;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;

public class SelectAccountController implements Controller {
	

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		String accountNumber = request.getParameter("accountNumber");
//		int accountNumber=Integer.parseInt(accountNumberStr);
//		System.out.println(accountNumber);
		
		AccountDAO dao = new AccountDAO();
		AccountVO accountVO= new AccountVO();
		accountVO = dao.selectAccountDAO(accountNumber);
		
		request.setAttribute("accountVO", accountVO);
		
		
//		HttpSession session = request.getSession(); // 세션 객체 얻기
//		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); 
		
//		if(userVO == null) {
//			return "/login/login.jsp";
//		} else {
//			String id = userVO.getId();
			
			return "/account/selectAccount.jsp"; // root는 Mission-WEB-MVC01 부터임
			
//		}
		
		
		
	}

}
