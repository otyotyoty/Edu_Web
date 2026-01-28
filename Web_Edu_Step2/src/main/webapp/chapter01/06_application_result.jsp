<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<div align="center">
        <h2>Application 영역</h2>
        <hr />
        1. 서버정보:
        <%=application.getServerInfo()%><br />
        2. 서블릿 API 버전정보:
        <%=application.getMajorVersion()%><br />
        3. 06_application_result.jsp 파일의 실제 경로:
        <%=application.getRealPath("06_application_result.jsp")%>
        <hr />

        <%
        application.setAttribute("username", "김민석");
        // 개발 중 디버깅 용도로 기록
        application.log("user login: username=김민석"); // 기록
        application.log("Debug: 현재 세션 상태=" + session.getAttribute("state")); // 확인

        application.setAttribute("count", 0);
        %>

        <a href="application_result.jsp">확인하기</a>
    </div>
</body>

</body>

</html>