package test;
import java.sql.*;
public class AdminLoginDAO {
	public AdminBean ab = null;
	public AdminBean login(String uN,String pW) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from Admon66 where uname=? and pword=?");
			ps.setString(1, uN);
			ps.setString(2, pW);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ab = new AdminBean();
				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setaddr(rs.getString(5));
				ab.setmId(rs.getString(6));
				ab.setphNo(rs.getLong(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
		
	}

}
