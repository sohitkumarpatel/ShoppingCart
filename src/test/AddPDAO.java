package test;
import java.sql.*;
public class AddPDAO {
 public int z;
 public int addP(ProductBean bb) {
	 try {
		 Connection con=DBConnection.getCon();
		 PreparedStatement ps=con.prepareStatement("insert into Products25 values(?,?,?)");
		 ps.setString(1,bb.getPcode());
		 ps.setString(2, bb.getpName());
		 ps.setDouble(3,bb.getpQty());
		 z=ps.executeUpdate();
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return z;
	 
 }
}
