<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 등록</title>
<link rel="stylesheet" type="text/css" href="../css/addrlist.css">
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>

	<!-- AddrDTO의 addr 즉 front에서 작성한 데이터를 DTO를 통해서 오라클에 저장 -->
	<jsp:useBean class="model.AddrDTO" id="addr">
		<jsp:setProperty name="addr" property="*" />
	</jsp:useBean>

	<!-- AddrDAO의 am 즉 backend의 AddrDAO 객체를 활용하여 데이터 등록, 출력, 찾기 등 수행-->
	<jsp:useBean class="model.AddrDAO" id="am" scope="application"></jsp:useBean>
	<%am.add(addr); %>
	<div class="container">
	
	<h2>등록 완료</h2>
	<p>이름: <jsp:getProperty name="addr" property="username" /></p>
	<p>전화번호: <jsp:getProperty name="addr" property="tel" /></p>
	<p>이메일: <jsp:getProperty name="addr" property="email" /></p>
	<p>성별: <jsp:getProperty name="addr" property="gender" /></p>
	<hr />
	<a href="addr_list.jsp">주소 목록 보기</a>
	
	</div>
</body>
</html>