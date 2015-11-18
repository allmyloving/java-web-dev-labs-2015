<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    errorPage="/WEB-INF/error.jsp"%>
<%@ include file="/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<c:if test="${not empty sessionScope.user }">
	You are logged in as ${sessionScope.user.login} [${sessionScope.user.role}].<br/>
	<a href="controller?command=logout">Log out</a>
</c:if>
<hr/>
</body>
</html>