package monSal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception;
	


}
