<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tweet</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");

	//로그인 정보 가져오기(session)
	String id = (String)session.getAttribute("id");
	
	//트윗 메세지 가져오기(request)
	String msg = request.getParameter("msg");
	
	//메세지 ArrayList의 msgs에서 예전 메세지 불러서
	ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");

	//msg == null 일때 msgs 만들어서 application영역에 저장
	if (msgs == null) {
		msgs = new ArrayList<String>();
		application.setAttribute("msgs", msgs);
	}
	//신규 메세지 추가
	msgs.add(id+":"+msg);
	
	//tweet_list 페이지로 이동
	response.sendRedirect("twitter_list.jsp");
	%>
</body>
</html>