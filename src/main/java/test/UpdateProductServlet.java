package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
public class UpdateProductServlet extends HttpServlet {
      protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
      {
    	  HttpSession hs = req.getSession();
    	  if(hs==null) {
    		  req.setAttribute("msg", "Session Expired..<br>");
    		  req.getRequestDispatcher("Msg.jsp").forward(req, res);
    	  }else {
    		  ArrayList<ProductBean> al = ((ArrayList<ProductBean>)hs.getAttribute("alist"));
    		  String pCode = req.getParameter("pcode");
    		  Iterator<ProductBean> it = al.iterator();
    		  while(it.hasNext()) {
    			  ProductBean pb = (ProductBean)it.next();
    			  if(pCode.equals(pb.getCode())) {
    				  pb.setPrice(Float.parseFloat(req.getParameter("price")));
    				  pb.setQty(Integer.parseInt(req.getParameter("qty")));
    				  int k = new UpdateProductDAO().update(pb);
    				  if(k>0) {
    					  req.setAttribute("msg", "Product Updated Successfully...<br>");
    					  req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
    				  }
    				  break;
    			  }
    		  }
    	  }
      }
}
