package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AddPServlet extends GenericServlet {
    public ServletContext sct;
    public ProductBean bb;
    @Override
    public void init() throws ServletException{
    	sct=this.getServletContext();
    	bb=new ProductBean();
    }
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String pCode=req.getParameter("pcode");
		String pName=req.getParameter("pname");
		int pQty=Integer.parseInt(req.getParameter("pqty"));
		String fName=(String) sct.getAttribute("fName");
		bb.setPcode(pCode);
		bb.setpName(pName);
		bb.setpQty(pQty);
		pw.println("Welcome Admin:"+fName+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("Link11.html");
		rd.include(req, res);		
		AddPDAO abd=new AddPDAO();
		int z=abd.addP(bb);
		if(z>0) {
			pw.println("<br>Product Added SuccessFully..!!");
		}
		
	}

}
