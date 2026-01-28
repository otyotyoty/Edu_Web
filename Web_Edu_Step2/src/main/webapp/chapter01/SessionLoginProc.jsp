<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionLoginProc</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
//Request 영역에서 받음
String id = request.getParameter("id");
String pass = request.getParameter("pass");
//session 영역에 저장
session.setAttribute("id", id); // session 영역에 저장
session.setAttribute("pass", pass);

// 5초 세션영역 저장
session.setMaxInactiveInterval(5);
%>

<h2><%= id %>님 환영합니다.</h2>
<a href=SessionShopping.jsp>SolShop</a>
<%-- 세션유지시간: <%=session.getMaxInactiveInterval(-1) %> 무제한(브라우저 닫을 때까지) --%>
<%-- 세션유지시간: <%=session.getMaxInactiveInterval(604800) %> --%> <!-- 7일 -->

</body>
</html>