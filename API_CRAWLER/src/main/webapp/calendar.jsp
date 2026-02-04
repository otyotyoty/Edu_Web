<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>달력</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Malgun Gothic', sans-serif;
	background: linear-gradient(135deg, #a8edea 0%, #fed6e3 100%);
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px;
}

.calendar-container {
	background: white;
	border-radius: 20px;
	padding: 30px;
	box-shadow: 0 20px 60px rgba(6, 182, 165, 0.3);
	max-width: 600px;
	width: 100%;
}

.calendar-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 30px;
}

.calendar-title {
	font-size: 1.8em;
	color: #06b6a5;
	font-weight: bold;
}

.nav-button {
	background: linear-gradient(135deg, #06b6a5 0%, #4ecdc4 100%);
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 10px;
	cursor: pointer;
	font-size: 16px;
	font-weight: bold;
	transition: transform 0.2s;
}

.nav-button:hover {
	transform: translateY(-2px);
}

.today-button {
	background: linear-gradient(135deg, #ff6b6b 0%, #ffa07a 100%);
	padding: 8px 15px;
	font-size: 14px;
}

.calendar-grid {
	display: grid;
	grid-template-columns: repeat(7, 1fr);
	gap: 8px;
}

.calendar-day-header {
	text-align: center;
	padding: 15px 0;
	font-weight: bold;
	font-size: 16px;
	color: #333;
}

.calendar-day-header.sun {
	color: #ff6b6b;
}

.calendar-day-header.sat {
	color: #4169e1;
}

.calendar-day {
	aspect-ratio: 1;
	display: flex;
	align-items: center;
	justify-content: center;
	border: 2px solid #e0e0e0;
	border-radius: 12px;
	cursor: pointer;
	background: white;
	transition: all 0.2s;
	font-size: 18px;
	font-weight: 500;
}

.calendar-day:hover {
	background: #f0fffe;
	border-color: #4ecdc4;
	transform: scale(1.05);
}

.calendar-day.empty {
	background: transparent;
	border: none;
	cursor: default;
}

.calendar-day.empty:hover {
	transform: none;
}

.calendar-day.today {
	background: linear-gradient(135deg, #06b6a5 0%, #4ecdc4 100%);
	color: white;
	font-weight: bold;
	border-color: #06b6a5;
	box-shadow: 0 5px 15px rgba(6, 182, 165, 0.3);
}

.calendar-day.selected {
	background: linear-gradient(135deg, #ff6b6b 0%, #ffa07a 100%);
	color: white;
	font-weight: bold;
	border-color: #ff6b6b;
	box-shadow: 0 5px 15px rgba(255, 107, 107, 0.3);
}

.calendar-day.sun {
	color: #ff6b6b;
}

.calendar-day.sat {
	color: #4169e1;
}

.selected-info {
	margin-top: 30px;
	padding: 20px;
	background: #f0fffe;
	border-radius: 10px;
	border-left: 4px solid #06b6a5;
	text-align: center;
}

.selected-info h3 {
	color: #06b6a5;
	font-size: 1.3em;
	margin-bottom: 10px;
}

.selected-info p {
	color: #333;
	font-size: 1.1em;
}

.no-selection {
	color: #999;
	font-style: italic;
}

.button-group {
	display: flex;
	gap: 10px;
	align-items: center;
}
</style>
</head>
<body>
	<script>
		function goToMonth(year, month) {
			window.location.href = 'CalendarServlet?year=' + year + '&month='
					+ month;
		}

		function selectDay(year, month, day) {
			window.location.href = 'CalendarServlet?year=' + year + '&month='
					+ month + '&day=' + day;
		}

		function goToday() {
			window.location.href = 'CalendarServlet';
		}
	</script>

	<div class="calendar-container">
		<!-- 헤더 -->
		<div class="calendar-header">
			<button class="nav-button"
				onclick="goToMonth(${prevYear}, ${prevMonth})">◀ 이전</button>

			<div class="calendar-title">${year}년${month}월</div>

			<div class="button-group">
				<button class="nav-button today-button" onclick="goToday()">오늘</button>
				<button class="nav-button"
					onclick="goToMonth(${nextYear}, ${nextMonth})">다음 ▶</button>
			</div>
		</div>

		<!-- 달력 -->
		<div class="calendar-grid">
			<!-- 요일 헤더 -->
			<div class="calendar-day-header sun">일</div>
			<div class="calendar-day-header">월</div>
			<div class="calendar-day-header">화</div>
			<div class="calendar-day-header">수</div>
			<div class="calendar-day-header">목</div>
			<div class="calendar-day-header">금</div>
			<div class="calendar-day-header sat">토</div>

			<!-- 빈 칸 (첫날 이전) -->
			<c:forEach var="i" begin="1" end="${firstDayOfWeek - 1}">
				<div class="calendar-day empty"></div>
			</c:forEach>

			<!-- 날짜 -->
			<c:forEach var="day" begin="1" end="${daysInMonth}">
				<c:set var="dayOfWeek" value="${(firstDayOfWeek + day - 2) % 7}" />
				<c:set var="isToday"
					value="${year == todayYear && month == todayMonth && day == todayDay}" />
				<c:set var="isSelected" value="${day == selectedDay && !isToday}" />

				<div
					class="calendar-day 
                            ${isToday ? 'today' : ''} 
                            ${isSelected ? 'selected' : ''}
                            ${dayOfWeek == 0 ? 'sun' : ''} 
                            ${dayOfWeek == 6 ? 'sat' : ''}"
					onclick="selectDay(${year}, ${month}, ${day})">${day}</div>
			</c:forEach>
		</div>

		<!-- 선택된 날짜 정보 -->
		<c:if test="${not empty selectedDate}">
			<div class="selected-info">
				<h3>📅 선택된 날짜</h3>
				<p>${selectedDate}</p>
			</div>
		</c:if>

		<c:if test="${empty selectedDate}">
			<div class="selected-info">
				<p class="no-selection">날짜를 클릭하면 선택됩니다</p>
			</div>
		</c:if>
	</div>
</body>
</html>