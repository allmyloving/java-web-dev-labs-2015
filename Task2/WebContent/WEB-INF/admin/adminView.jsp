<%@ include file="/WEB-INF/head.jsp"%>
<title>Admin view</title>
</head>
<body>
	<%@ include file="/WEB-INF/header.jsp"%>
	<h1>
		<fmt:message key="label.users" />
	</h1>
	<br />
	<c:if test="${not empty requestScope.deleteMode}">
		<fmt:message key="action.confirm_delete">
			<fmt:param value="${userLogin}"></fmt:param>
		</fmt:message>
		<form name="deleteUser"
			action="controller?command=deleteUser&userLogin=${userLogin}"
			method="post">
			<a href="#" onclick="document.forms['deleteUser'].submit()"><fmt:message
					key="action.confirm" /></a>
		</form>
		<!-- <a
			href="controller?command=adminView&delete=true&userLogin=${userLogin}">
			<fmt:message key="action.confirm" />
		</a> -->
	</c:if>

	<c:if test="${fn:length(users) !=0 }">
		<table border="1">
			<tr>
				<td><fmt:message key="label.login" /></td>
				<td><fmt:message key="label.email" /></td>
				<td><fmt:message key="label.full_name" /></td>
			</tr>
			<c:forEach var="user" items="${requestScope.users}">
				<tr>
					<td>${user.login}</td>
					<td>${user.email}</td>
					<td>${user.fullName}</td>
					<c:if test="${sessionScope.user.role=='admin'}">
						<td><a
							href="controller?command=editUserView&userLogin=${user.login}"><fmt:message
									key="action.edit" /></a></td>
						<td><a
							href="controller?command=adminView&deleteMode=true&userLogin=${user.login}"><fmt:message
									key="action.delete" /></a></td>
					</c:if>

					<c:if
						test="${((sessionScope.user.role == 'user') && (user.login == sessionScope.user.login))}">
						<td><a
							href="controller?command=editUserView&userLogin=${user.login}"><fmt:message
									key="action.edit" /></a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<c:if test="${sessionScope.user.role=='admin'}">
		<a href="controller?command=addUserView"><fmt:message
				key="action.add_new_user" /></a>
	</c:if>
</body>
</html>