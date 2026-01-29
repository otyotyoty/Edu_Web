<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.KanjiDTO" %>
<%@ page import="model.StudyProgressDTO" %>
<%
    String level = request.getParameter("level");
    if (level == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    
    // 오늘 학습한 한자들을 진행 상태에 추가
    @SuppressWarnings("unchecked")
    List<KanjiDTO> todayKanji = (List<KanjiDTO>) session.getAttribute("todayKanji_" + level);
    StudyProgressDTO progress = (StudyProgressDTO) session.getAttribute("studyProgress_" + level);
    
    if (todayKanji != null && progress != null) {
        for (KanjiDTO kanji : todayKanji) {
            progress.addLearnedKanji(kanji.getKanji());
        }
        session.setAttribute("studyProgress_" + level, progress);
    }
    
    // 오늘의 한자 세션 제거
    session.removeAttribute("todayKanji_" + level);
    
    // 완료 페이지로 이동
    response.sendRedirect("studyComplete.jsp?level=" + level);
%>