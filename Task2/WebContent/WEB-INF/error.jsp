<%@ include file="head.jsp"%>
<title>Gotcha</title>
</head>
<body>
	An error occurred.<br/>
	<c:if test="${not empty pageContext.exception}">
		Error: <c:out value="${pageContext.exception}"/></br>
	</c:if>
	<c:if test="${not empty errors}">
		<h1>Errors:</h1>
		<c:forEach var="error" items="${errors}">
			<p>
				<c:out value="${error}" /></br>
			</p>
		</c:forEach>
	</c:if>
	
	<a href="javascript: history.go(-1)">Go back</a>
</body>
</html>