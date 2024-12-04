package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllProductsServlet extends HttpServlet{
	@Override
       protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
       {
    	   HttpSession hs = req.getSession();
    		if(hs==null) {
    			req.setAttribute("msg", "SessionExpired..<br>");
    			req.getRequestDispatcher("Msg.jsp").forward(req, res);
    			
    		}else {
    			ArrayList<ProductBean> al = new ViewAllProductsDAO().retrieve();
    			hs.setAttribute("alist", al);
    			req.getRequestDispatcher("ViewAllProducts.jsp").forward(req, res);
    		}
       }
}
