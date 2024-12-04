<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("alist");
out.println("page belongs to :"+ab.getfName()+"<br>");
if(al.size()==0){
	out.println("Products not availble..<br>");
}else{
	Iterator<ProductBean> it = al.iterator();
	while(it.hasNext()){
		ProductBean pb = (ProductBean)it.next();
		out.println(pb.getCode()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"+pb.getPrice()+"&nbsp&nbsp"
				+pb.hetQty()+"&nbsp&nbsp"+"<a href='edit'>Edit</a>"+"&nbsp&nbsp"+
		"<a href='delete'>Delete</a>"+"<br>");
	}
}
%>
<a href="product.html">AddProduct</a>
<a href="logout">Logout</a>
</body>
</html>