package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edt")
public class EditProfileServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
  {
	  HttpSession hs = req.getSession(false);
	  if(hs==null) {
		  req.setAttribute("msg", "SessionExpired..<br>");
		  req.getRequestDispatcher("Msg.jsp").forward(req, res);
		  
	  }else{
		  ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("alist");
		  String pCode = req.getParameter("pcode");
		  Iterator<ProductBean> it = al.iterator();
		  while(it.hasNext()) {
			  ProductBean pb = (ProductBean)it.next();
			  if(pCode.equals(pb.getClass())) {
				  req.setAttribute("pbean", pb);
				  req.getRequestDispatcher("EditProfile.jsp").forward(req, res);
				  break;
			  }
		  }//end loop
	  }
  }
}
