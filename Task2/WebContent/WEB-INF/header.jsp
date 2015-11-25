<%@ include file="taglib.jspf" %>
<fmt:setLocale value="${currentLocale}" />
<fmt:setBundle basename="resources" />
<c:if test="${not empty sessionScope.user }">
	<fmt:message key="message.header">
		<fmt:message key="${sessionScope.user.role}" var="role" />
		<fmt:param value="${sessionScope.user.login}" />
		<fmt:param value="${role}" />
	</fmt:message>
	<br />
	<a href="controller?command=logout"> <fmt:message
			key="action.log_out" /></a>
</c:if>
<br />
<fmt:message key="label.current_locale">
	<fmt:param value="${currentLocale}" />
</fmt:message>
<br />
<fmt:message key="label.choose_locale" />
<form action="locale" method="get">
	<input onclick="submit()" type="radio" value="ru" name="newLocale"
		<c:if test="${currentLocale == 'ru'}">CHECKED</c:if> /> RU <input
		onclick="submit()" type="radio" value="en" name="newLocale"
		<c:if test="${currentLocale == 'en'}">CHECKED</c:if> /> EN <br />
	<!-- <input
			type="submit" value="Submit" />-->
</form>
<hr />