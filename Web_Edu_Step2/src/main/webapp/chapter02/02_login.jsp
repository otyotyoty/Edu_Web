<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="../css/join.css">
</head>
<body>

<!-- 	
	scope="page" => 현재 JSP에서만 쓰고 바로 버리는 객체
	
	scope		저장 위치			유지 범위
	page		JSP 페이지		현재 페이지에서만
	request		request 객체		요청 1번 동안
	session		session 객체		브라우저 종료 / 만료 전까지
	application	ServletContext	서버 종료 전까지
	-->
	
	<center>
		<h2>로그인</h2>
		<form action="LoginProc.jsp" method="post">
			<table align="center" width="300" border="1">
				<tr height="40">
					<td width="120" align="center">아이디</td>
					<td width="180" align="center"><input type="text"
						name="userid" size="10" placeholder="id"></td>
				</tr>
				<tr height="40">
					<td width="120" align="center">패스워드</td>
					<td width="180" align="center"><input type="password"
						name="password" size="10" placeholder="password"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="로그인"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>