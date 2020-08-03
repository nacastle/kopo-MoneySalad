package monSal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monSal.transaction.dao.TransactionDAO;
import monSal.transaction.vo.TransactionVO;

public class SelectAllTransactionController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
//		System.out.println("실행될거같은데");
		request.setCharacterEncoding("utf-8");
		
		String accountNumber = request.getParameter("accountNumber");
		
		TransactionDAO dao = new TransactionDAO();
		
		List<TransactionVO> transactionList = dao.selectAllTransaction(accountNumber);
		
		request.setAttribute("transactionList", transactionList);
		
		
		return "/transaction/selectAllTransaction.jsp";
	}

}
