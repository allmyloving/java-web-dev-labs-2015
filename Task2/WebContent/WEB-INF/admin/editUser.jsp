<%@ include file="/WEB-INF/head.jsp"%>
<title>Edit user</title>
</head>
<body>
	<%@ include file="/WEB-INF/header.jsp"%>
	<form action="controller" method="post">
		<c:if test="${empty currentUser}">
			<fmt:message key="label.login" />
			<input name="login" />
			<br />
		</c:if>
		<fmt:message key="label.password" />
		&nbsp<input name="password" type="password"
			value="${currentUser.password}" /> <br />
		<fmt:message key="label.full_name" />
		<input name="fullName" value="${currentUser.fullName}" /> <br />
		<fmt:message key="label.email" />&nbsp <input name="email" value="${currentUser.email}" /> <br />
		<input type="submit" value="Save" /> <input type="hidden"
			name="command" value="editUser">
	</form>
</body>
</html>