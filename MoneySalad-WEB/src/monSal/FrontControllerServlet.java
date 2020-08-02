package monSal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {
	
	HandlerMapping mappings = null;
	
	

	@Override
	public void init(ServletConfig config) throws ServletException { // ServletConfig는 servlet접속시 xml에 있는 설정값들(init-params)
		// TODO Auto-generated method stub
		
		String propLoc = config.getInitParameter("propertyLocation");
		mappings = new HandlerMapping(propLoc);  // 한번 property Location 잡아주고 그 로케이션에서 다른 컨트롤러 계속 접근할 예정
	}
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String context = request.getContextPath(); //프로젝트명까지
		String uri = request.getRequestURI(); //전체 uri를 찍어줌
		uri = uri.substring(context.length()); // /Mission-WEB-MVC01/*.do
		String callPage = null;
		
		try {
			
			Controller control = mappings.getController(uri);
			if (control != null) {// 이상한.do가 들어왓을때 처리안하게끔
				callPage = control.handleRequest(request, response); 
// 즉, /a.jsp 로 들어온 요청을 /a.jsp 내에서 RequestDispatcher를 사용하여 b.jsp로 요청을 보낼 수 있습니다. 또는 a.jsp에서 b.jsp로 처리를 요청하고 b.jsp에서 처리한 결과 내용을 a.jsp의 결과에 포함시킬 수 있습니다.
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage); 
				dispatcher.forward(request, response);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}


}
