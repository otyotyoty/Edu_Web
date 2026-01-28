<%@page import="model.AddrDTO"%>
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

	<!-- AddrDAO의 am 즉 backend의 AddrDAO 객체를 활용하여 데이터 등록, 출력, 찾기 등 수행-->
	<jsp:useBean class="model.AddrDAO" id="am" scope="application" />
	<div class="container">
		<h2>주소록</h2>
		<a href="03_addr_form.jsp">주소록 추가</a>
		<p></p>
		<form action="sname.jsp" method="get">
			<input type="text" name="sname" placeholder="이름으로 검색" />
			<p></p>
			<input type="submit" value="검색" />
		</form>
		<p></p>
		<table border="1"> <!-- 표에 테두리 -->
			<thead> <!-- 표의 머리글(제목) 부분 -->
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>성별</th>
				</tr>
			</thead>
			<tbody>
			<tr>
			<% for(AddrDTO ab:am.getAddrlist()){ %>
			<td><%=ab.getUsername() %></td>
			<td><%=ab.getTel() %></td>
			<td><%=ab.getEmail() %></td>
			<td><%=ab.getGender() %></td>
			</tr>
			<% } %>
			</tbody>
		</table>

	</div>

</body>
</html>