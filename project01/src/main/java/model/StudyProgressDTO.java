
package model;

import java.util.HashSet;
import java.util.Set;
//학습 진행 상태 관리 DTO
public class StudyProgressDTO {
    private String level;
    private int dailyCount;
    private Set<String> learnedKanji;  // 학습한 한자들
    
    public StudyProgressDTO(String level, int dailyCount) {
        this.level = level;
        this.dailyCount = dailyCount;
        this.learnedKanji = new HashSet<>();
    }
    
    public String getLevel() {
        return level;
    }
    
    public int getDailyCount() {
        return dailyCount;
    }
    
    public Set<String> getLearnedKanji() {
        return learnedKanji;
    }
    
    public void addLearnedKanji(String kanji) {
        learnedKanji.add(kanji);
    }
    
    public boolean isLearned(String kanji) {
        return learnedKanji.contains(kanji);
    }
    
    public void resetProgress() {
        learnedKanji.clear();
    }
}