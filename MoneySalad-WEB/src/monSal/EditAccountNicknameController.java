package monSal;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import monSal.QnAboard.dao.BoardDAO;
import monSal.QnAboard.vo.BoardFileVO;
import monSal.QnAboard.vo.BoardVO;
import util.KopoFileNamePolicy;

public class EditAccountNicknameController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String accountNumber = request.getParameter("accountNumber");
		
		request.setAttribute("accountNumber", accountNumber);
		
		
	
		return "/account/editAccountNickname.jsp";

	}

}
