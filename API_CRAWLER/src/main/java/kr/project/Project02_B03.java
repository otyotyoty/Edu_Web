package kr.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Project02_B03 {

	public static void main(String[] args) {
		try {
			String query = "서울 날씨";
			String url = "https://m.search.naver.com/search.naver?where=m&query="
					+ java.net.URLEncoder.encode(query, "UTF-8");
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
