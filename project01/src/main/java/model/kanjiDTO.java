package model;

public class kanjiDTO {

	private String kanji; // 한자 (글자)
	private int level; // 한자 레벨

	private String unyomi1; // 음독 1
	private String unyomi2; // 음독 2
	private String unyomi3; // 음독 3
	private String unyomi4; // 음독 4

	private String kunyomi1; // 훈독 1
	private String kunyomi2; // 훈독 2
	private String kunyomi3; // 훈독 3
	private String kunyomi4; // 훈독 4

	private String explanation; // 한자 설명
	private String exampleWord; // 예시 단어
	
	public String getKanji() {
		return kanji;
	}
	public void setKanji(String kanji) {
		this.kanji = kanji;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getUnyomi1() {
		return unyomi1;
	}
	public void setUnyomi1(String unyomi1) {
		this.unyomi1 = unyomi1;
	}
	public String getUnyomi2() {
		return unyomi2;
	}
	public void setUnyomi2(String unyomi2) {
		this.unyomi2 = unyomi2;
	}
	public String getUnyomi3() {
		return unyomi3;
	}
	public void setUnyomi3(String unyomi3) {
		this.unyomi3 = unyomi3;
	}
	public String getUnyomi4() {
		return unyomi4;
	}
	public void setUnyomi4(String unyomi4) {
		this.unyomi4 = unyomi4;
	}
	public String getKunyomi1() {
		return kunyomi1;
	}
	public void setKunyomi1(String kunyomi1) {
		this.kunyomi1 = kunyomi1;
	}
	public String getKunyomi2() {
		return kunyomi2;
	}
	public void setKunyomi2(String kunyomi2) {
		this.kunyomi2 = kunyomi2;
	}
	public String getKunyomi3() {
		return kunyomi3;
	}
	public void setKunyomi3(String kunyomi3) {
		this.kunyomi3 = kunyomi3;
	}
	public String getKunyomi4() {
		return kunyomi4;
	}
	public void setKunyomi4(String kunyomi4) {
		this.kunyomi4 = kunyomi4;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getExampleWord() {
		return exampleWord;
	}
	public void setExampleWord(String exampleWord) {
		this.exampleWord = exampleWord;
	}

}
