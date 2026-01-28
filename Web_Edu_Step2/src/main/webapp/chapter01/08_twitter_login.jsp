<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter_Login</title>
<link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>

<!-- 
application : “서버 전체 공용”

서버 전체에서 하나만 존재. 모든 사용자가 같은 값 공유
서버가 꺼질 때까지 유지

session : “사용자 한 명 전용”

사용자(브라우저) 1명당 하나. 사용자별로 따로 관리
일정 시간 후 자동 삭제 가능
 -->

	<div align="center">
		<h2>로그인</h2>
		<form action="twitter_list.jsp" method="post">
			<label>사용자 이름:</label>
			<input type="text" name="id" placeholder="아이디를 입력하세요" required /> <br> <br>
			<input type="submit" value="로그인" />
		</form>
	</div>

</body>
</html>