<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL_url</title>
</head>
<body>
    <h3>&lt;c:url&gt;</h3>
    <c:url var="target" value="choose.jsp">
        <c:param name="sel1">Butter</c:param>
        <c:param name="sel2">Garlic</c:param>
    </c:url>
    <hr />
    
    단순출력 : ${target }
    <br>
    <!-- sel1,sel2라는 변수발 데이터도 가져감 -->
    링크출력 :
    <a href="${target }">상품목록</a>
    <p></p>
    <hr />
    
</body>
</html>