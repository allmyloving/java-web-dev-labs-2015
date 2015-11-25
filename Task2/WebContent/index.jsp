<%@ include file ="/WEB-INF/head.jsp"%>
<jsp:directive.page errorPage="/WEB-INF/error.jsp"/>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
Hi, this is JSP.
<br/>
<jsp:forward page="/controller?command=loginView"></jsp:forward>
</body>
</html>