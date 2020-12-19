package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
    public ServletContext sct;
    public void init() throws ServletException{
    	//sct=this.getServletContext();
    }
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		String submit=req.getParameter("s1");
		UserDAO Id=new UserDAO();
		boolean z=Id.validate(uName, pWord, submit,sct);
		if(z) {
			//String fName=(String) sct.getAttribute("fName");
			HttpSession hs=req.getSession();
			hs.setAttribute("UserName", uName);
			//pw.println("Welcome user:"+ fName +"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req, res);
			
			
		}else {
			pw.println("Invalid UserName and Password..<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
	}

}
