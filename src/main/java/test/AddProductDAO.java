package test;
import java.sql.*;
public class AddProductDAO {
    public int k=0;
    public int insert(ProductBean pb) {
    	try {
    		Connection con = DBConnection.getCon();
    		PreparedStatement ps = con.prepareStatement
    				("insert into Product66 values(?,?,?,?)");
    		ps.setString(1, pb.getCode());
    		ps.setString(2, pb.getName());
    		ps.setFloat(3, pb.getPrice());
    		ps.setInt(4, pb.getQty());
    		ps.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return k;
    }
}
