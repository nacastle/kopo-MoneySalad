package monSal;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardVO;
import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;

public class SelectAllAccountController implements Controller {
	

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); 
		
//		if(userVO == null) {
//			return "/login/login.jsp";
//		} else {
//			String id = userVO.getId();
			
			AccountDAO dao = new AccountDAO();
			List<AccountVO> accountList = new ArrayList<>();
			accountList = dao.selectAllAccountDAO(userVO);
			
			request.setAttribute("accountList", accountList);
			
			return "/account/selectAllAccount.jsp"; // root는 Mission-WEB-MVC01 부터임
			
//		}
		
		
		
	}

}
