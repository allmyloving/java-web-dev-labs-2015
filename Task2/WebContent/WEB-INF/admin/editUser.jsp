<%@ include file="/WEB-INF/head.jsp"%>
<title>Edit user</title>
</head>
<body>
	<%@ include file="/WEB-INF/header.jsp"%>
	<form action="controller" method="post">
		<c:choose>
			<c:when test="${empty currentUser}">
				<fmt:message key="label.login" />
				<input name="login" />
				<br />
			</c:when>
			<c:otherwise>
				<input type="hidden" name="login" value="${currentUser.login}"/>
			</c:otherwise>
		</c:choose>
		<fmt:message key="label.password" />
		<input name="password" type="password" value="${currentUser.password}" />
		<br />
		<fmt:message key="label.full_name" />
		<input name="fullName" value="${currentUser.fullName}" /> <br />
		<fmt:message key="label.email" />
		<input name="email" value="${currentUser.email}" /> <br />
		<fmt:message key="action.save" var="save" />
		<input type="submit" value="${save}" /> <input type="hidden"
			name="command" value="editUser">
	</form>
</body>
</html>