package test;
import java.sql.*;
import javax.servlet.*;

public class UserDAO {
	public boolean z;
	public boolean validate(String uName,String pWord,String name,ServletContext sct) {
		try {
			Connection con=DBConnection.getCon();
			if(name.equals("UserLogin")) {
				
				PreparedStatement ps=con.prepareStatement("select * from UserReg20 where uname=? and pWord=?");
				ps.setString(1, uName);
				ps.setString(2, pWord);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					z=true;
					//sct.setAttribute("fName",rs.getString(3));
				}
			}
			else {
				PreparedStatement ps=con.prepareStatement("select * from Admin25 where uname=? and pWord=?");
				ps.setString(1, uName);
				ps.setString(2, pWord);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					z=true;
					sct.setAttribute("fName", rs.getString(3));
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
		
	}

}
