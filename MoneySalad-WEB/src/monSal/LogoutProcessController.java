package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
//		System.out.println("로그아웃 컨트롤러 시작!");
		
		HttpSession session = request.getSession(); // 세션 객체 얻기

//		LoginVO userVO = (LoginVO)session.getAttribute("userVO");		
//		userVO = null;		
//		session.setAttribute("userVO", userVO);
		
		session.invalidate();
//		session.setAttribute("userVO", null);
		String url = request.getContextPath()+"/login.do";
//		System.out.println("로그아웃 url:" + url);
		request.setAttribute("url", url);
		
		
		return "/login/logoutProcess.jsp";
	}

}
