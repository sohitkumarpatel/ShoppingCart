package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class GetProductsServlet extends HttpServlet {
	 ProductsDAO productsdao=new ProductsDAO();
	@Override
	public void init() throws ServletException{
		 ProductsDAO productsdao=new ProductsDAO();
	}
	
	 
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		 HttpSession hs=req.getSession();
		 if(hs==null) {
			 RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			 rd.forward(req, res);
			 return;
		 }
		 String uname=(String) hs.getAttribute("UserName");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><head>");
		pw.println("<title>MY Shopping Cart</title>");
		pw.println("</head><body bgcolor='MediumSeaGreen'>");
		pw.println("<table width='100%' height='90%' border='1'>");
		pw.println("<tr align='center'>");
		pw.println("<td height='39'colspan='2'><strong><font size='5'>MY SHOPPING CART</font></strong></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td width='18%' height='500' valign='top'><p>&nbsp;</p>");
		pw.println("<blockquote><p>");
		pw.println("<a href='"+res.encodeURL("getProducts")+"'>");
		pw.println("View Products</a></p><p>");
		pw.println("<a href='"+res.encodeURL("getCart")+"'>");
		pw.println("View Cart Details</a></p><p>");
		pw.println("<a href='Login.html'>");
		pw.println("Logout</a></p>");
		pw.println("</blockquote></td>");
		pw.println("<td width='82%' align='left' valign='top'><p>");
		pw.println("<font size='6'>Welcome:"+uname+"</font><p>");
		pw.println("<form  method='post' action='"+res.encodeURL("addProducts")+"'>");
		pw.println("<table width='100%' border='1'>");
		pw.println("<tr>");
		pw.println("<th width='8%'>check</th>");
		pw.println("<th width='24%'>product Code</th>");
		pw.println("<th width='28%'>product Name</th>");
		pw.println("<th width='20%'>Available Quantity</th>");
		pw.println("<th width='20%'>Required Quantity</th>");
		pw.println("</tr>");
		Collection products=productsdao.getProducts();
		if(products==null) {
			pw.println("<tr><td colspan='5' align='center'>");
			pw.println("No Products Available");
			pw.println("</td></tr>");
		}else {
			Iterator i=products.iterator();
			while(i.hasNext()) {
				Product p=(Product) i.next();
				pw.println("<tr>");
				pw.println("<td align='center'>");
				pw.println("<input type='checkbox' name='products' value='"+p.getCode()+"'/>");
				pw.println("<input type='hidden' name='"+p.getCode()+"Name'value='"+p.getName()+"'/></td>");
				pw.println("<td>"+p.getCode()+"</td>");
				pw.println("<td>"+p.getName()+"</td>");
				pw.println("<td>"+p.getQty()+"</td>");
				pw.println("<td>");
				pw.println("<input type='text' name='"+p.getCode()+"'/>");
				pw.println("</td></tr>");
			}
		}
		pw.println("</table>");
		pw.println("<br/><center>");
		pw.println("<input type='submit' value='Add Product to Cart'/>");
		pw.println("</center>");
		pw.println("</form>");
		pw.println("</td></tr>");
		pw.println("<tr align='center'>");
		pw.println("<td colspan='2'>");
		pw.println("<em>&copy:CopyRights 2019-20</em></td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</body></html>");
		pw.flush();
		pw.close();
		
	}
      // ProductsDAO productsdao;
}
