<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5dc;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 400px;
        }
        h2 {
            margin-bottom: 20px;
        }
        hr {
            margin: 20px 0;
        }
        .message {
            font-size: 18px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
	<!-- class:LoginDAO id=login scope=page-> PageContext -->
<!-- 	
	scope="page" => 현재 JSP에서만 쓰고 바로 버리는 객체
	
	scope		저장 위치			유지 범위
	page		JSP 페이지		현재 페이지에서만
	request		request 객체		요청 1번 동안
	session		session 객체		브라우저 종료 / 만료 전까지
	application	ServletContext	서버 종료 전까지
	-->
	
	<jsp:useBean class="model.LoginDAO" id="login" scope="page">
		<jsp:setProperty name="login" property="*" />
	</jsp:useBean>
	
	<div align="center">
  	<h2>로그인</h2>
	<hr />
	<%
	if(login.checkUser()){
		out.println("로그인 성공");
	}else{
		out.println("로그인 실패");
	}
   %>   
   <hr />
   고객의 아이디: <jsp:getProperty name="login" property="userid" />
   고객의 비밀번호: <jsp:getProperty name="login" property="password" />
   </div>
   
</body>
</html>