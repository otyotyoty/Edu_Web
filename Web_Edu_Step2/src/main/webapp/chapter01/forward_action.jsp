<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward_action</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
	min-height: 100vh; /* 최소 화면 전체 높이 */
	display: flex;
	align-items: center; /* 세로 가운데 */
	justify-content: center; /* 가로 가운데 */
	color: white;
}

h2 {
	text-align: center;
	font-size: 2rem;
}
</style>
</head>
<body>
	<h2>forward_action.jsp</h2>

	<%
	request.setCharacterEncoding("utf-8"); // 사용자가 보낸 한글 데이터를 깨지지 않게 읽기 위한 설정. 
										// request.getParameter() 를 쓰기 전에 반드시 실행
	%>
	
<!-- 현재 JSP 실행을 중단하고 같은 요청(request)으로 다른 JSP로 넘기는 기능 (URL 그대로)-->
<jsp:forward page="page_control_end.jsp"> 
<!-- 이동하면서 요청 파라미터(phone) 를 같이 전달 -->
<jsp:param name="phone" value="010-1234-5678" />
</jsp:forward>

</body>
</html>