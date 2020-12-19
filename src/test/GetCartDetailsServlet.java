package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GetCartDetailsServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.forward(req,  res);
			return;
		}
		String uname=(String) hs.getAttribute("UserName");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><head>");
		pw.println("<title>Shopping Cart</title>");
		pw.println("</head><body bgcolor='Violet'>");
		pw.println("<table width='100%' height='90%' border='1'>");
		pw.println("<tr align='center'>");
		pw.println("<td height='39' colspan='2'><strong><font size='5'>My Shopping Site</font></strong></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td width='18%' height='500' valign='top'><p>&nbsp;</p>");
		pw.println("<blockqoute>");
		pw.println("<p><a href='"+res.encodeURL("getProducts")+"'>View Products</a></p>");
		pw.println("<p><a href='"+res.encodeURL("getCart")+"'>View Cart Details</a></p>");
		pw.println("<p><a href='Login.html'>Logout</a></p>");
		pw.println("</blockquote></td>");
		pw.println("<td width='82%' align='left' valign='top'><p><font size='6'>Welcome:"+uname+"</font></p>");
		pw.println("<center>Your Cart contains the following products");
		pw.println("<table width='80%' border='1'>");
		pw.println("<tr>");
		pw.println("<th width='24%'>Product Code</th>");
		pw.println("<th width='28%'>Product Name</th>");
		pw.println("<th width='20%'>Quantity<th>");
		pw.println("</tr>");
		 Collection products=(Collection) hs.getAttribute("products");
		 if(products==null) {
			 pw.println("<tr><td colspan='3' align='center'>");
			 pw.println("You Have not added any products into cart");
			 pw.println("</td></tr>");
		 }else {
			 Iterator i=products.iterator();
			 while(i.hasNext()) {
				 Product p=(Product) i.next();
				 pw.println("<tr>");
				 pw.println("<td>"+p.getCode()+"</td>");
				 pw.println("<td>"+p.getName()+"</td>");
				 pw.println("<td>"+p.getQty()+"</td>");
				 pw.println("</tr>");
				 
			 }
				 
		 }
		 pw.println("</table></center>");
		 pw.println("</td></tr>");
		 pw.println("<tr align='center'>");
		 pw.println("<td colspan='2'><em>&copy;CopyRights 2019-20</em></td>");
		 pw.println("</tr>");
		 pw.println("</table>");
		 pw.println("</body></html>");
		 pw.flush();
		 pw.close();
		 
		
	}

}
