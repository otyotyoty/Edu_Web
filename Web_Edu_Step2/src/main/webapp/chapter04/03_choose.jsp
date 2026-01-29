<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>choose</title>
</head>
<body bgcolor="#FFFFcc">

<%-- 			

<!-- EL 표현식 -->
<!-- Scriptlet 표현식. 위와 동일 -->

${param.id}
<%= request.getParameter("id") %>

${name}
<%= request.getAttribute("name") %>
(application.setAttribute("name", 값) 처럼 어딘가 저장되어 있어야 함)

${addr.username}
<%= addr.getUsername() %>


${name} 이라고 쓰면 JSP가 자동으로 아래 순서로 찾는다 :
pageScope
requestScope
sessionScope
applicationScope

 --%>

	<h3>&lt;c:choose&gt;</h3>
	<form>
		<select name="sel">
			<option>--</option>
			<option ${param.sel == 'a'? 'selected':'' }>a</option>
			<!-- 'a'를 선택했다면 ${param.sel} 값: "b" , selected 속성 추가 -->
			<option ${param.sel == 'b'? 'selected':'' }>b</option>
			<option ${param.sel == 'c'? 'selected':'' }>c</option>
			<option ${param.sel == 'd'? 'selected':'' }>d</option>
		</select> <input type="submit" value="선택" />
	</form>

	<p></p>
	<hr />

	<c:choose>
		<c:when test="${param.sel == 'a' }">a 선택됨</c:when>
		<c:when test="${param.sel == 'b' }">b 선택됨</c:when>
		<c:when test="${param.sel == 'c' }">c 선택됨</c:when>
		<c:when test="${param.sel == 'd' }">d 선택됨</c:when>
		<c:otherwise>a,b,c,d 이외의 것을 선택함</c:otherwise>
	</c:choose>

	<%-- 	
	### `<c:choose>`
- 여러 조건 중 하나를 선택하는 블록 시작
- Java의 `switch` 또는 `if-else if-else`와 동일

	### `<c:when test="조건">`
- 조건이 **true**일 때 실행
- Java의 `if` 또는 `else if`와 동일
- **첫 번째로 true인 조건만 실행되고 나머지는 무시됨**

	### `<c:otherwise>`
- 모든 `<c:when>` 조건이 false일 때 실행
- Java의 `else` 또는 `default`와 동일
 --%>

</body>
</html>