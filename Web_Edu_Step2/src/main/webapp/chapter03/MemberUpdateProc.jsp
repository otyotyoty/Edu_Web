<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>업데이트</title>
<link rel="stylesheet" type="text/css" href="../css/member.css">
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");
	%>

	<jsp:useBean class="model.MemberDTO" id="mdto">
		<jsp:setProperty name="mdto" property="*" />
	</jsp:useBean>

	<%
/* 	// 🔍 디버깅: 값 확인
	out.println("폼에서 받은 ID: " + mdto.getId() + "<br>");
	out.println("폼에서 받은 비밀번호: " + mdto.getPass1() + "<br>"); */
	
	MemberDAO mdao = new MemberDAO();
	//데이터베이스에 있는 비밀번호
	String pass = mdao.getPass(mdto.getId());
	
/* 	out.println("DB의 비밀번호: " + pass + "<br>"); */

	if (mdto.getPass1().equals(pass)) {
		mdao.updateMember(mdto);
		response.sendRedirect("MemberList.jsp");
	} else {
	%>
	<script type="text/javascript">
		alert("패스워드가 일치하지 않습니다.")
		history.go(-1);
	</script>

	<%
	}
	%>

</body>
</html>