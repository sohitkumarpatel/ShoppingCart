package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class RegServlet1 extends HttpServlet{
 public RegBean rb;
 public ServletContext sct;
 @Override
 public void init() throws ServletException{
	 rb=new RegBean();
	 sct=this.getServletContext();
 }
 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		rb.setuName(uName);
		rb.setpWord(pWord);
		rb.setfName(fname);
		rb.setlName(lname);
		sct.setAttribute("beanRef", rb);
		RequestDispatcher rd=req.getRequestDispatcher("Register2.html");
		rd.forward(req, res);
		
	}

}
