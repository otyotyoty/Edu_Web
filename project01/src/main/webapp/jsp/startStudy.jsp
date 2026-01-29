<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.KanjiDTO" %>
<%@ page import="model.StudyProgressDTO" %>
<%@ page import="repository.KanjiRepository" %>
<%@ page import="util.StudyManager" %>
<%
    String level = request.getParameter("level");
    String countStr = request.getParameter("count");
    
    if (level == null || countStr == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    
    int dailyCount = Integer.parseInt(countStr);
    
    // 세션에서 학습 진행 상태 가져오기
    StudyProgressDTO progress = (StudyProgressDTO) session.getAttribute("studyProgress_" + level);
    
    // 진행 상태가 없거나 레벨이 다르면 새로 생성
    if (progress == null || !progress.getLevel().equals(level)) {
        progress = new StudyProgressDTO(level, dailyCount);
        session.setAttribute("studyProgress_" + level, progress);
    } else {
        // 기존 진행 상태가 있으면 일일 학습 개수만 업데이트
        progress = new StudyProgressDTO(level, dailyCount);
        StudyProgressDTO oldProgress = (StudyProgressDTO) session.getAttribute("studyProgress_" + level);
        progress.getLearnedKanji().addAll(oldProgress.getLearnedKanji());
        session.setAttribute("studyProgress_" + level, progress);
    }
    
    // 전체 한자 리스트 가져오기
    List<KanjiDTO> allKanji = KanjiRepository.findByLevel(level);
    
    // 모든 한자를 학습했는지 확인
    if (StudyManager.isAllLearned(allKanji, progress.getLearnedKanji())) {
        // 모두 학습했으면 초기화 여부 확인 페이지로 이동
        response.sendRedirect("studyComplete.jsp?level=" + level);
        return;
    }
    
    // 랜덤으로 한자 선택
    List<KanjiDTO> todayKanji = StudyManager.selectRandomKanji(
        allKanji, 
        progress.getLearnedKanji(), 
        dailyCount
    );
    
    // 세션에 오늘의 한자 저장
    session.setAttribute("todayKanji_" + level, todayKanji);
    
    // 학습 페이지로 이동
    response.sendRedirect("study.jsp?level=" + level + "&index=0");
%>