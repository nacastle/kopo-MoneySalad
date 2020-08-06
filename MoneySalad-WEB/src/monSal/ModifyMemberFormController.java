package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.login.vo.LoginVO;
import monSal.member.dao.MemberDAO;
import monSal.member.vo.MemberVO;

public class ModifyMemberFormController implements Controller{
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		
		String id = ((LoginVO)session.getAttribute("userVO")).getId();
		
		MemberVO member = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		member = dao.selectMember(id);
		
		request.setAttribute("member", member);
		
		return "/member/modifyMemberForm.jsp";
	}

}
