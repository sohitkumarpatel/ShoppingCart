package test;
import java.sql.*;
import java.util.*;
public class ProductsDAO {
  
	public Collection getProducts() {
		try {
			Connection con=DBConnection.getCon();
			//PreparedStatement ps=con.prepareStatement("select * from Products25");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Products25");
			ArrayList products=new ArrayList();
			while(rs.next()) {
				Product p=new Product();
				p.code=rs.getString(1);
				p.name=rs.getString(2);
				p.qty=rs.getDouble(3);
				products.add(p);
			}
			return products;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
