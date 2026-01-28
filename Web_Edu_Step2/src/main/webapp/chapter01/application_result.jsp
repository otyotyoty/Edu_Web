<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application_result.jsp</title>
</head>
<body>
	<div align="center">
		<h2>Application</h2>
		username에 설정된 값:
		<%=application.getAttribute("username")%><br />

		<%
		Integer count = (Integer) application.getAttribute("count");

		int cnt = count.intValue() + 1;
		application.setAttribute("count", cnt);
		%>

		count:
		<%=cnt%>
	</div>
</body>
</html>