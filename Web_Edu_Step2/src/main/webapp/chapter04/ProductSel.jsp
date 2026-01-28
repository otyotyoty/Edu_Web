<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 선택 결과</title>
<link rel="stylesheet" type="text/css" href="../css/member.css">
</head>
<body>
	<div align="center">
		<h2>선택 결과</h2>
		<hr>
		
		<jsp:useBean class="model.Product" id="product" scope="session" />
		
		<c:choose>
			<c:when test="${param.sel == 'item1'}">
				<h3>item1을 선택하셨습니다.</h3>
				<p>가격: <c:out value="${product.num1}" />원</p>
			</c:when>
			
			<c:when test="${param.sel == 'item2'}">
				<h3>item2를 선택하셨습니다.</h3>
				<p>가격: <c:out value="${product.num2}" />원</p>
			</c:when>
			
			<c:when test="${param.sel == 'item3'}">
				<h3>item3을 선택하셨습니다.</h3>
				<p>가격: <c:out value="${product.num3}" />원</p>
			</c:when>
			
			<c:when test="${param.sel == 'item4'}">
				<h3>item4를 선택하셨습니다.</h3>
				<p>가격: <c:out value="${product.num4}" />원</p>
			</c:when>
			
			<c:when test="${param.sel == 'item5'}">
				<h3>item5를 선택하셨습니다.</h3>
				<p>가격: <c:out value="${product.num5}" />원</p>
			</c:when>
			
			<c:otherwise>
				<h3>상품을 선택해주세요.</h3>
			</c:otherwise>
		</c:choose>
		
		<hr>
		<p></p>
		<a href="ProductList.jsp">다시 선택하기</a>
	</div>
</body>
</html>