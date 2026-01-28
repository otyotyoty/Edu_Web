<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request_result</title>
<link rel="stylesheet" href="../css/style01.css" />
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	
	<div align="center">
	<h2>Request Test</h2>
	<hr />
	<table width="400" border="1" cellspacing="1" cellpadding="5">
	<tr>
		<td width="50">이름</td>
		<td width="100"><%= request.getParameter("username") %></td>
	</tr>
	
	<tr>
		<td width="50">직업</td>
		<td width="100"><%= request.getParameter("job") %></td>
	</tr>
	
	<tr>
		<td width="50">관심분야</td>
		<td width="100">
		<% String favorites[]=request.getParameterValues("favorite");
		    for(String  favorite:favorites){
		    	out.print(favorite+" ");
		    }
		  %>
		</td>
	</tr>
	
	</table>
	</div>
</body>
</html>