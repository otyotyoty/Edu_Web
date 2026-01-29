<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String level = request.getParameter("level");
    
    // 오늘의 한자 세션만 제거 (학습 진행 상태는 유지)
    if (level != null) {
        session.removeAttribute("todayKanji_" + level);
    }
    
    // 메인 페이지로 이동
    response.sendRedirect("index.jsp");
%>