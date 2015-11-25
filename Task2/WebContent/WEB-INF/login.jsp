<%@ include file="head.jsp"%>
<title>Log in</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
	<c:if test="${not empty sessionScope.user }">
		<jsp:forward page="/controller?command=adminView" />
	</c:if>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="login" />
		<fmt:message key="label.login" />
		: <input type="text" name="login" />
		<fmt:message key="label.password" />
		: <input type="password" name="password" />
		<fmt:message key="action.log_in" var="logIn" />
		<input type="submit" value="${logIn}" />
	</form>
</body>
</html>