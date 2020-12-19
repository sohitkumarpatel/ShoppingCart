package test;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
public class ViewProductsServlet1 extends GenericServlet {
    public Connection con;
    @Override
    public void init() throws ServletException{
    	con=DBConnection.getCon();
    }
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 ServletContext sct=this.getServletContext();
	String fName=(String) sct.getAttribute("fName");	
	pw.println("Welcome Admin:"+fName+"<br>");
	RequestDispatcher rd=req.getRequestDispatcher("Link11.html");
	rd.include(req, res);
	try {
		PreparedStatement ps=con.prepareStatement("select * from products25");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pw.println("<br>"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getInt(3));
			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}

}
