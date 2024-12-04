package test;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;
public class ViewAllProductsDAO{
      public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
      public ArrayList<ProductBean> retrieve()
      {
    	  try {
    		  Connection con = DBConnection.getCon();
    		  PreparedStatement ps = con.prepareStatement
    				  ("select * from Product66");
    		  ResultSet rs = ps.executeQuery();
    		  while(rs.next()) {
    			  ProductBean pb = new ProductBean();
    			  pb.setCode(rs.getString(1));
    			  pb.setName(rs.getString(2));
    			  pb.setPrice(rs.getFloat(3));
    			  ((ProductBean) ps).setQty(rs.getInt(4));
    			  al.add(pb);
    		  }
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  return al;
      }
}
