package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class FinalRegServlet extends GenericServlet {
    public ServletContext sct;
    public RegBean rb;
    @Override
    public void init() throws ServletException{
    	sct=this.getServletContext();
    	rb=(RegBean) sct.getAttribute("beanRef");
    }
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RegDAO rd=new RegDAO();
		int k=rd.register(rb);
		if(k>0) {
			pw.println("User Registration Successfully..!!");
			RequestDispatcher rds=req.getRequestDispatcher("Login.html");
			rds.include(req, res);
		}
	}

}
