<%@ include file="taglib.jspf"%>
<!--<c:set var="currentLocale" value="${cookie['currentLocale'].value}"/>-->
<c:out value="${sessionScope.currentLocale}"/><br/>

<fmt:setLocale value="${sessionScope.currentLocale}" />
<fmt:setBundle basename="${bundleBasename}" />

<c:if test="${not empty sessionScope.user }">
	<fmt:message key="message.header">
		<fmt:message key="${sessionScope.user.role}" var="role" />
		<fmt:param value="${sessionScope.user.login}" />
		<fmt:param value="${role}" />
	</fmt:message>
	<br />
	
	<!--<c:url var="pageUrl" value="">
		<c:forEach items="${param}" var="entry">
			<c:if test="${entry.key != 'command'}">
				<c:param name="${entry.key}" value="${entry.value}" />
			</c:if>
		</c:forEach>
	</c:url>-->
	<a href="controller?command=logout"> <fmt:message
			key="action.log_out" /></a>
</c:if>
<br />

<c:if test="${fn:length(localeList) != 0}">
	<c:forEach items="${localeList}" var="localeItem">
	
		<c:url var="pageUrl" value="">
			<c:forEach items="${param}" var="entry">
				<c:if test="${entry.key != 'lang'}">
					<c:param name="${entry.key}" value="${entry.value}" />
				</c:if>
			</c:forEach>
			<c:param name="lang" value="${localeItem}" />
		</c:url>

		<fmt:message key="${localeItem}" var="loc" />
		<c:if
			test="${fn:toLowerCase(sessionScope.currentLocale) == fn:toLowerCase(localeItem)}">
			<b>
		</c:if>
		<a href="${pageUrl}">${loc} </a>
		<c:if
			test="${fn:toLowerCase(sessionScope.currentLocale) == fn:toLowerCase(localeItem)}">
			</b>
		</c:if>

	</c:forEach>
</c:if>
<hr />