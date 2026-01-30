package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import model.KanjiDTO;
import model.StudyProgressDTO;

//학습 관리 유틸리티 클래스
public class StudyManager {
    
    // 학습하지 않은 한자 중에서 랜덤으로 선택
    public static List<KanjiDTO> selectRandomKanji(List<KanjiDTO> allKanji, 
                                                     Set<String> learnedKanji, 
                                                     int count) {
        // 학습하지 않은 한자 필터링
        List<KanjiDTO> unlearnedKanji = new ArrayList<>();
        for (KanjiDTO kanji : allKanji) {
            if (!learnedKanji.contains(kanji.getKanji())) {
                unlearnedKanji.add(kanji);
            }
        }
        
        // 학습하지 않은 한자가 없으면 전체 리스트 사용 (반복 학습)
        if (unlearnedKanji.isEmpty()) {
            unlearnedKanji = new ArrayList<>(allKanji);
        }
        
        // 섞기
        Collections.shuffle(unlearnedKanji);
        
        // 요청한 개수만큼 반환 (부족하면 있는 만큼만)
        int selectCount = Math.min(count, unlearnedKanji.size());
        return unlearnedKanji.subList(0, selectCount);
    }
    
    // 전체 학습 완료 여부 확인
    public static boolean isAllLearned(List<KanjiDTO> allKanji, Set<String> learnedKanji) {
        return learnedKanji.size() >= allKanji.size();
    }
}
