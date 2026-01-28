<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseProc</title>
</head>
<body>
	<%
	//서버(JSP)는 로그인 판단, 브라우저(JS)는 알림과 화면 이동을 담당
	
	// 오라클에 저장된 데이터로 가설
	String dbid = "soldesk";
	String dbpass = "12345";

	// request 객체에 id, pass 받아오기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");

	if (dbid.equals(id) && dbpass.equals(pass)) {
		session.setAttribute("id", id); // session 영역에 저장. 페이지가 바뀌어도 값이 사라지지 않게 하기 위해 사용
		session.setAttribute("pass", pass); // session 영역에 저장
		response.sendRedirect("ResponseLogin.jsp");
	} else {
	%>
	<script> // 이 부분은 서버가 아니라 브라우저에서 실행
		alert("아이디와 비밀번호가 일치하지 않습니다.")
		history.go(-1);
	</script>
	<%
	}
	%>
	

</body>
</html>