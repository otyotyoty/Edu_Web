package kr.project;

import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Project02_B02 {

   public static void main(String[] args) {
      try {
         String url = "https://finance.naver.com/marketindex/exchangeList.naver";
            Document doc = Jsoup.connect(url).get();

            Elements rows = doc.select("table.tbl_exchange tbody tr");
            
            for (Element row : rows) {
               String nation = row.select("td.tit").text() ;  //국가명
               String rate = row.select("td.sale").text() ;  //매매기준율 
               System.out.println(nation + " : " + rate + "원");
            }
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

}
