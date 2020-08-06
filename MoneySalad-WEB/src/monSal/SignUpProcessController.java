package monSal;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monSal.member.dao.MemberDAO;

public class SignUpProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("이건 찍히나????");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String emailId = request.getParameter("email_id");
		String emailDomain = request.getParameter("email_domain1");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String post = request.getParameter("post");
		String basicAddr = request.getParameter("basic_addr");
		String detailAddr = request.getParameter("detail_addr");
		String type = request.getParameter("type");
		
//		MemberVO member = new MemberVO( id,  name,  password,  emailId,  emailDomain,  tel1,
//				 tel2,  tel3,  post,  basicAddr,  detailAddr,  type,  "");
//		
		MemberDAO dao = new MemberDAO();
		dao.insertMember(id, name, password, emailId, emailDomain, tel1, tel2, tel3, post, basicAddr, detailAddr, type);
		
		
		

		
		request.setAttribute("url", request.getContextPath()+"/login.do");
		request.setAttribute("msg", "회원가입이 완료되었습니다.");
		
		
		
		
		return "/member/signUpProcess.jsp"; // root는 Mission-WEB-MVC01 부터임

	}

}
