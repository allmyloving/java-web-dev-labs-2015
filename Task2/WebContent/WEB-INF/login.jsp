<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
</head>
<body>
<c:if test="${not empty sessionScope.user }">
<%--	<jsp:forward page="/WEB-INF/admin/adminView.jsp"/>--%>
	<jsp:forward page="/controller?command=adminView"/>
</c:if>
<form action="controller" method="post">
	<input type="hidden" name="command" value="login">
	Login: <input type="text" name="login">
	Password: <input type="password" name="password">
	<input type="submit" value="Log in">
</form>
</body>
</html>