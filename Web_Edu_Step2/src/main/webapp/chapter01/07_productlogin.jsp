<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>product_login</title>
<link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>
<div align="center">
		<h2>로그인</h2>
		<form method="POST" action="selectProduct.jsp">
			<label>사용자 이름:</label> 
			<input type="text" name="username" placeholder="이름을 입력하세요" required /> <br> <br> 
			<input type="submit" value="로그인" />
		</form>
	</div>
</body>
</html>