<%@ include file="taglib.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:directive.page errorPage="/WEB-INF/error.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hi, this is JSP.
<br/>
<jsp:forward page="/controller?command=loginView"></jsp:forward>
<form action="controller">
	<input type="submit" value="Login">
	<input type="hidden" name="command" value="loginView">
</form>
</body>
</html>