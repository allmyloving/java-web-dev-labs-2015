<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit user</title>
</head>
<body>
<form action="controller" method="post">
	<c:if test="${empty currentUser}">
		Login &nbsp<input name="login"/><br/>
	</c:if>
	Password &nbsp<input name="password" type="password" value="${currentUser.password}"/> <br/>
	Full name&nbsp<input name="fullName" value="${currentUser.fullName}"/> <br/>
	E-mail&nbsp <input name="email" value="${currentUser.email}"/> <br/>
	<input type="submit" value="Save"/>
	
	<input type="hidden" name="command" value="editUser">
</form>
</body>
</html>