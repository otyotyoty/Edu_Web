<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>MemberJoinProc</title>
<link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>
	<%
	//한글깨짐 방지
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass1 = request.getParameter("pass1");
	String pass2 = request.getParameter("pass2");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	String[] hobby = request.getParameterValues("hobby");
	String job = request.getParameter("job");
	String age = request.getParameter("age");
	String info = request.getParameter("info");

	if (!pass1.equals(pass2)) {
	%>
	<script>
		alert("비밀번호가 일치하지 않습니다.")
		history.go(-1); //이전 페이지로 다시 이동
	</script>
	<%
	}
	%>

	<center>
		<h2>회원 정보</h2>
		<hr />
		<table width="600" border="1">
			<tr height="50">
				<td width="150" align="center">아이디</td>
				<td width="150" align="left"><%=id%></td>
			</tr>
			
			<tr height="50">
				<td width="150" align="center">패스워드</td>
				<td width="300" align="left"><%=pass1%></td>
			</tr>

			<tr height="50">
				<td width="150" align="center">패스워드확인</td>
				<td width="300" align="left"><%=pass2%></td>
			</tr>
			<tr height="50">
				<td width="150" align="center">이메일</td>
				<td width="300" align="left"><%=email%></td>
			</tr>
			<tr height="50">
				<td width="150" align="center">성별</td>
				<td width="300" align="left"><%=gender%></td>
			</tr>
			<tr height="50">
				<td width="150" align="center">주소</td>
				<td width="300" align="left"><%=address%></td>
			</tr>
			<tr height="50">
				<td width="150" align="center">전화번호</td>
				<td width="300" align="left"><%=phone%></td>
			</tr>
			<tr height="50">
				<td width="150" align="center">관심분야</td>
				<td width="300" align="left">
					<%
					for (String ho : hobby) {
						out.println(ho + "  ");
					}
					%>
				</td>
			</tr>
			<tr>
				<td width="150" align="center">직업은</td>
				<td width="300" align="left"><%=job%></td>
			</tr>
			<tr height="50">
				<td width="150" align="center">연령은</td>
				<td width="300" align="left"><%=age%></td>
			</tr>
			<tr height="50">
				<td width="150" align="center">하고싶은 말</td>
				<td width="300" align="left"><%=info%></td>
			</tr>
		</table>
	</center>



</body>
</html>