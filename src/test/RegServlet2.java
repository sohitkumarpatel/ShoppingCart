package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class RegServlet2 extends GenericServlet{
      public RegBean rb;
     public ServletContext sct;
     @Override
     public void init()  throws ServletException {
    	sct=this.getServletContext() ;
    	rb=(RegBean) sct.getAttribute("beanRef");
     }
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String addr=req.getParameter("addr");
		long phno=Long.parseLong(req.getParameter("phno"));
		String mId=req.getParameter("mid");
		rb.setAddr(addr);
		rb.setPhno(phno);
		rb.setmId(mId);
		pw.println("Your Registration Details are valid..!!");
		pw.println("<a href='dis'>CLICK</a>");
		pw.println("To View Registration Details..!!");
	}

	

}