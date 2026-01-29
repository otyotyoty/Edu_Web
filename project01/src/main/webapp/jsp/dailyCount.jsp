<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.KanjiDTO" %>
<%@ page import="repository.KanjiRepository" %>
<%
    String level = request.getParameter("level");
    if (level == null || level.isEmpty()) {
        response.sendRedirect("index.jsp");
        return;
    }
    
    // 해당 레벨의 총 한자 개수 확인
    List<KanjiDTO> kanjiList = KanjiRepository.findByLevel(level);
    int totalCount = kanjiList.size();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학습 개수 선택</title>
    <link rel="stylesheet" href="../css/main.css">
</head>
<body>
    <div class="main-container">
        <h1 class="main-title">JLPT <%= level %></h1>
        <p class="main-subtitle">총 <%= totalCount %>개의 한자</p>
        
        <div class="count-section">
            <h2>일일 학습 한자 개수를 선택하세요</h2>
            <div class="count-buttons">
                <button class="count-button" onclick="startStudy(2)">
                    <div class="count-number">2개</div>
                    <div class="count-desc">가볍게 시작</div>
                </button>
                <button class="count-button" onclick="startStudy(4)">
                    <div class="count-number">4개</div>
                    <div class="count-desc">적당한 학습</div>
                </button>
                <button class="count-button" onclick="startStudy(6)">
                    <div class="count-number">6개</div>
                    <div class="count-desc">집중 학습</div>
                </button>
            </div>
        </div>
        
        <div class="back-section">
            <button class="back-button" onclick="location.href='index.jsp'">
                ← 레벨 선택으로 돌아가기
            </button>
        </div>
    </div>
    
    <script>
        function startStudy(count) {
            window.location.href = 'startStudy.jsp?level=<%= level %>&count=' + count;
        }
    </script>
</body>
</html>