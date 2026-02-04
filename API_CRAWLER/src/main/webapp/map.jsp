<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지도 검색</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Malgun Gothic', sans-serif;
	background: linear-gradient(135deg, #ffc3a0 0%, #ffafbd 100%);
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px;
}

.container {
	background: white;
	border-radius: 20px;
	padding: 40px;
	box-shadow: 0 20px 60px rgba(255, 175, 189, 0.3);
	max-width: 800px;
	width: 100%;
}

h1 {
	text-align: center;
	color: #ff6f91;
	margin-bottom: 30px;
	font-size: 2em;
}

.search-box {
	display: flex;
	gap: 10px;
	margin-bottom: 30px;
}

input[type="text"] {
	flex: 1;
	padding: 15px;
	border: 2px solid #ffe0e9;
	border-radius: 10px;
	font-size: 16px;
	transition: border 0.3s;
}

input[type="text"]:focus {
	outline: none;
	border-color: #ffafbd;
}

button {
	padding: 15px 30px;
	background: linear-gradient(135deg, #ff6f91 0%, #ffafbd 100%);
	color: white;
	border: none;
	border-radius: 10px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: transform 0.2s;
}

button:hover {
	transform: translateY(-2px);
}

.result-box {
	background: #fff5f7;
	padding: 20px;
	border-radius: 10px;
	margin-bottom: 20px;
	border-left: 4px solid #ff6f91;
}

.info {
	margin: 10px 0;
	font-size: 15px;
	color: #333;
}

.info strong {
	color: #ff6f91;
	display: inline-block;
	width: 100px;
}

.map-image {
	text-align: center;
	margin-top: 20px;
}

.map-image img {
	max-width: 100%;
	border-radius: 10px;
	box-shadow: 0 10px 30px rgba(255, 111, 145, 0.2);
}

.error {
	background: #ffe6e6;
	color: #c33;
	padding: 15px;
	border-radius: 10px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>네이버 지도 검색</h1>

		<form action="MapServlet" method="post">
			<div class="search-box">
				<input type="text" name="address"
					placeholder="주소를 입력하세요 (예: 서울특별시 종로구 종로12길 15)" required>
				<button type="submit">검색</button>
			</div>
		</form>

		<c:if test="${not empty success}">
			<c:choose>
				<c:when test="${success}">
					<div class="result-box">
						<div class="info">
							<strong>도로명 주소:</strong> ${roadAddress}
						</div>
						<div class="info">
							<strong>지번 주소:</strong> ${jibunAddress}
						</div>
						<div class="info">
							<strong>경도 (X):</strong> ${x}
						</div>
						<div class="info">
							<strong>위도 (Y):</strong> ${y}
						</div>
					</div>

					<div class="map-image">
						<img src="images/${imageName}" alt="지도 이미지">
					</div>
				</c:when>

				<c:otherwise>
					<div class="error">${message}</div>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
</body>
</html>