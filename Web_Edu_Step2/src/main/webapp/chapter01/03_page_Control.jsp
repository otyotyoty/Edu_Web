<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page_Control</title>
<link rel="stylesheet" type="text/css" href="../css/page_control.css">
</head>
<body>
<%-- 
값 유지하며 내부 이동 → forward
새 페이지로 완전히 이동 → sendRedirect

jsp:forward (forward) >> <jsp:forward page="next.jsp" />
특징 : 요청 1번, 같은 request 사용, URL 안 바뀜
사용 예 : 에러 메시지 전달

response.sendRedirect() >> response.sendRedirect("next.jsp");
특징 : 요청 2번, 새 request 생성, URL 바뀜
사용 예: 로그인 성공 후 이동, 새 페이지로 전환
 --%>
 
	<h2>Forward_SendRedirect</h2>
	<hr />
	<form action="forward_action.jsp" method="post">
		forward_action: <input type="text" name="username" />
		<input type="submit" value="Requst" />	
	</form>
	<p/>
	<hr />
	<p/>
	<form action="response_sendRedirect.jsp" method="post">
		Response_sendRedirect: <input type="text" name="username" />
		<input type="submit" value="Response" />	
	</form>

</body>
</html>