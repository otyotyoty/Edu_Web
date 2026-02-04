package kr.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_A {

	public static void main(String[] args) {
		String url = "https://news.naver.com/";

		try {
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();

			// 주요 뉴스 제목 선택자 (2025년 기준, 구조 변경 가능)
			Elements headlines = doc.select("a[href^=https://n.news.naver.com/article/]");

			System.out.println("▶ 주요 뉴스 헤드라인:");
			for (Element headline : headlines) {
				System.out.println(" - " + headline.text());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
