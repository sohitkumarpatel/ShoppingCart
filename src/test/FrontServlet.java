package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class FrontServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String submit=req.getParameter("s1");
		if(submit.equals("Admin")) {
			RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
			rd.forward(req, res);
			
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.forward(req, res);
		}
	}

}
