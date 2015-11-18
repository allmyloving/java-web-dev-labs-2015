<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	isErrorPage="true"%>
<%@ include file="/WEB-INF/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gotcha</title>
</head>
<body>
	An error occurred.<br/>
	<c:if test="${not empty errors}">
		<h1>Errors:</h1>
		<c:forEach var="error" items="${errors}">
			<p>
				<c:out value="${error}" />
			</p>
		</c:forEach>
	</c:if>
	<a href="javascript: history.go(-1)">Go back</a>
</body>
</html>