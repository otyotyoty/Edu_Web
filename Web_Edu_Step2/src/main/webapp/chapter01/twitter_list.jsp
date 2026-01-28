<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>twitter_list</title>
<link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");

	// 사용자가 입력한 id를 세션에 저장
	String id = request.getParameter("id");

	if (id == null) {
		id = (String) session.getAttribute("id");
		// 세션에도 없으면
		if (id == null) {
			response.sendRedirect("08_twitter_login.jsp");
			return; //sendRedirect 후 코드 실행 방지
		}
	}
	session.setAttribute("id", id);
	%>

	<div align="center">
		<h3>My Simple Twitter</h3>
		<p> 환영합니다, <strong><%=id%></strong>님!</p>

		<form action="tweet.jsp" method="post">
			<label>트윗 입력:</label>
			<input type="text" name="msg" placeholder="메세지를 입력하세요" required />
			<input type="submit" value="Tweet" />
		</form>
		<hr />
		
		<!-- 트윗 목록 -->
		<ul>
			<%
			ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");

			if (msgs != null && !msgs.isEmpty()) {
				int index = 0;
				for (String msg : msgs) {
			%>
			<li><%=msg%>
				<%-- 			
				<form action="delete_tweet.jsp" method="get" style="display: inline;">
					<input type="hidden" name="index" value="<%=index%>" /> 
					<input type="submit" value="삭제" />
				</form>
				 --%>
				</li>
			<%
					index++;
				}
			} else {
			%>
			<p>트윗이 없습니다. 첫 번째 트윗을 남겨보세요!</p>
			<%
			}
			%>
		</ul>
	</div>

</body>
</html>