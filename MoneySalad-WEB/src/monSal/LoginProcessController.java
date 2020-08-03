package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.dao.LoginDAO;
import monSal.login.vo.LoginVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPassword(password);
		
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.login(loginVO);
		
		String msg = "";
		String url = "";
		
		if(userVO == null) {
			//로그인 실패
			msg = "로그인 실패\\n로그인 페이지로 이동합니다.";
			url = request.getContextPath() + "/login.do";  //forward include xml은 프로젝트명이 포함됨. 그래서 /login.do만 입력해도됨
			System.out.println("url"+url);
		}else {
			//로그인 성공
			msg = "로그인에 성공하였습니다.";
			url = request.getContextPath();
			
			HttpSession session = request.getSession(); // 세션 객체 얻기
			session.setAttribute("userVO", userVO);
			
			AccountDAO accountDao = new AccountDAO();
			List<AccountVO> accountList = accountDao.selectAllAccountDAO(userVO);
			session.setAttribute("accountList", accountList);
			
			
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/login/loginProcess.jsp";
	}

}
