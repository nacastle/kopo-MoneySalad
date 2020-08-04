package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.vo.LoginVO;

public class EditAccountNicknameProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");

		
		String accountNumber = request.getParameter("accountNumber");
		String newNickname = request.getParameter("newNickname");
		
		AccountDAO dao = new AccountDAO();
		dao.reviseAccountDAO(newNickname, accountNumber);
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		LoginVO userVO = (LoginVO)session.getAttribute("userVO"); //
		List<AccountVO> accountList = dao.selectAllAccountDAO(userVO);
		session.setAttribute("accountList", accountList);
		
		request.setAttribute("url", request.getContextPath()+"/editAccountNicknameForm.do");
		request.setAttribute("msg", "별칭이 수정되었습니다.");
		
		
		
	
		return "/account/editAccountNicknameProcess.jsp";

	}

	

}
