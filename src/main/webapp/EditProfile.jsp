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
AdimnBean ab = (AdminBean)session.getAttribute("abean");
ProductBean pb = (ProductBean)request.getAttribute("pbean");
out.println("page belongs to Admin:"+ab.getfName()+"<br>");
%>
<form action="update" method="post">
<input type="hidden" name="pcode" value=<%=pb.getCode()
%>>
ProductQty:<input type="text" name ="qty" value=<%=pb.getQty %>><br>
<input type="submit" value="UpdateProduct">
</form>
</body>
</html>