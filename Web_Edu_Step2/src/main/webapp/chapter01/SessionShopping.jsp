<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionShopping</title>
</head>
<body>
<h2>SolShop</h2>
<% String id=(String)session.getAttribute("id"); %>
<h3><%= id %>님 환영합니다.</h3>

세션유지시간: <%=session.getMaxInactiveInterval() %> <!-- 5초 -->
</body>
</html>