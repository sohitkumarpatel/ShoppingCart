package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession hs=req.getSession(false);
		if(hs!=null) 
			hs.invalidate();
		    RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		    rd.forward(req, res);
	}
	
}
