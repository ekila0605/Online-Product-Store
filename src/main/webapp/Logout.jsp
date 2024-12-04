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
session.removeAttribute("abean");
session.removeAttribute("alist");
session.invalidate();
out.println("Admin Logged out Successfully..<br>");
%>
<%@include file="home.html" %>
</body>
</html>