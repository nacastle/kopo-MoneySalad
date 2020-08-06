package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monSal.member.dao.MemberDAO;

public class IdValidationController implements Controller{
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("찍히나?");
		
		String checkId = request.getParameter("checkId");
		System.out.println("checkId:"+checkId);
		
		MemberDAO dao = new MemberDAO();
		boolean idCheck = dao.checkId(checkId);
		
		String msg = "";
		
		if(idCheck) {
			msg = "available";
		} else if (!idCheck) {
			msg = "unavailable";
		}
		
		System.out.println("msg: "+msg);
		
		request.setAttribute("msg", msg);
		
		
		
		return "/member/idValidation.jsp"; // root는 Mission-WEB-MVC01 부터임
	}
	

}
