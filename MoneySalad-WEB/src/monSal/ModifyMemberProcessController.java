package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.login.vo.LoginVO;
import monSal.member.dao.MemberDAO;
import monSal.member.vo.MemberVO;

public class ModifyMemberProcessController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		
		String id = ((LoginVO)session.getAttribute("userVO")).getId();
		String emailId = request.getParameter("email_id");
		String emailDomain = request.getParameter("email_domain1");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String post = request.getParameter("post");
		String basicAddr = request.getParameter("basic_addr");
		String detailAddr = request.getParameter("detail_addr");
		
		MemberVO member = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		member = dao.selectMember(id);
		member.setEmailId(emailId);
		member.setEmailDomain(emailDomain);
		member.setTel1(tel1);
		member.setTel2(tel2);
		member.setTel3(tel3);
		member.setPost(post);
		member.setBasicAddr(basicAddr);
		member.setDetailAddr(detailAddr);
	
		dao.modifyMember(member);
		
		request.setAttribute("url", request.getContextPath()+"/myPageMain.do");
		request.setAttribute("msg", "회원수정이 완료되었습니다.");
		
		return "/member/modifyMemberProcess.jsp";
	}

}
