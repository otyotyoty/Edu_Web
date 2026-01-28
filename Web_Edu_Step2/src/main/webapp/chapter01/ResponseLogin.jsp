<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseLogin</title>
</head>
<body>
<% String id=(String)session.getAttribute("id"); %>
<h2><%= id %>님 환영합니다.</h2>

</body>
</html>