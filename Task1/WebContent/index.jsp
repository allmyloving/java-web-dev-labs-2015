<!DOCTYPE html>
<%@ include file="/taglib.jspf"%>
<html>
<head>
<meta charset="UTF-8">
<title>Calculate</title>
</head>
<body>
<form action="MyServlet">
<input type="text" name="var1">
<select name="operation">
	<option value="add">+</option>
	<option value="sub">-</option>
	<option value="mul">*</option>
	<option value="div">/</option>
</select>
<input type="text" name="var2">
<br/>
<br/>
<input type="submit" value="Calculate">
</form>
<c:out value="${result}"/>
<c:out value="${errors}"/>
</body>
</html>