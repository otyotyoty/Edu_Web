<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose</title>
</head>
<body bgcolor="#FFFFcc">
	<h3>&lt;c:choose&gt;</h3>
	<%-- request.getParameter()와 같은 역할 : ${param.sel } --%>
	<form>
		<select name="sel">
			<option>선택</option>
			<option ${param.sel=='a'? 'selected':''}>a</option>
			<option ${param.sel=='b'? 'selected':''}>b</option>
			<option ${param.sel=='c'? 'selected':''}>c</option>
			<option ${param.sel=='d'? 'selected':''}>d</option>
			<option ${param.sel=='Butter'? 'selected':''}>Butter</option>
			<option ${param.sel=='Garlic'? 'selected':''}>Garlic</option>
		</select> <input type="submit" value="선택" />
	</form>
	<p />
	<hr />
	<c:choose>
		<c:when test="${param.sel=='a'}">a를 선택</c:when>
		<c:when test="${param.sel=='b'}">b를 선택</c:when>
		<c:when test="${param.sel=='c'}">c를 선택</c:when>
		<c:when test="${param.sel=='Butter'}">Butter를 선택</c:when>
		<c:when test="${param.sel=='Garlic'}">Garlic를 선택</c:when>
		<c:otherwise>
            a,b,c 이외의 것을 선택하셨습니다.
    </c:otherwise>
	</c:choose>
</body>
</html>