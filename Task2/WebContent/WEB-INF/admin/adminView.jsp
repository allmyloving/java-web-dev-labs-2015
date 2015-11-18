<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin view</title>
</head>
<body>
	<h1>Users</h1>
	<br />
	<c:if test="${not empty requestScope.deleteMode}">
		Do you really want to delete user <c:out value="${userLogin}"></c:out>?
		<a
			href="controller?command=adminView&delete=true&userLogin=${userLogin}">Confirm
			delete</a>
	</c:if>

	<c:if test="${fn:length(users) !=0 }">
		<table border="1">
			<tr>
				<td>Login</td>
				<td>E-mail</td>
				<td>Full name</td>
			</tr>
			<c:forEach var="user" items="${requestScope.users}">
				<tr>
					<td>${user.login}</td>
					<td>${user.email}</td>
					<td>${user.fullName}</td>
					<c:if test="${sessionScope.user.role=='admin'}">
						<td><a
							href="controller?command=editUserView&userLogin=${user.login}">Edit</a></td>
						<td><a
							href="controller?command=adminView&deleteMode=true&userLogin=${user.login}">Delete</a></td>
					</c:if>

					<c:if
						test="${((sessionScope.user.role == 'user') && (user.login == sessionScope.user.login))}">
						<td><a
							href="controller?command=editUserView&userLogin=${user.login}">Edit</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br/>
	<c:if test="${sessionScope.user.role=='admin'}">
		<a href="controller?command=addUserView">Add new user</a>
	</c:if>
</body>
</html>