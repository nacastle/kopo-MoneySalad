package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monSal.account.dao.AccountDAO;
import monSal.account.vo.AccountVO;
import monSal.login.dao.LoginDAO;
import monSal.login.vo.LoginVO;
import monSal.member.dao.MemberDAO;

public class ResignProcessController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // 세션 객체 얻기
		String id = ((LoginVO)session.getAttribute("userVO")).getId();
		
		MemberDAO dao = new MemberDAO();
		dao.deleteMember(id);
		
		request.setAttribute("msg", "회원탈퇴가 완료되었습니다.");
		request.setAttribute("url", request.getContextPath()+"/login.do");
		
		return "/member/resignProcess.jsp";
	}

}
