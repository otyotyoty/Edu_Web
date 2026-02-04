package kr.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_D {
   
   //지도 메서드
   public static void map_service(String point_x, String point_y, String address) {
      
      String client_id = "4uvs2g5ckm";
      String client_secret = "SYwdP2YMcMtMOIXpKSS8wQwbRkumWx2BoFxMhbRV";
      String URL_STATICMAP = "https://maps.apigw.ntruss.com/map-static/v2/raster?";
      
      try {
         // 공백을 기준으로 String 분리한 encode
            String pos = URLEncoder.encode(point_x + " " + point_y, "UTF-8");
            String url = URL_STATICMAP;
            url += "center=" + point_x + "," + point_y; // 찾고자 하는 위치가 정가운데 오도록 설정
            url += "&level=16&w=700&h=500"; // 700X500
            
         // 풍선 도움말
            url += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(address, "UTF-8");
            URL u = new URL(url);
            
            HttpsURLConnection con = (HttpsURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            
            if(responseCode == 200) {
               InputStream is = con.getInputStream();
               
               int read=0;
               byte[] bytes = new byte[1024];
               
               //중복이 안되게 생성
               String tempname=Long.valueOf(new Date().getTime()).toString();
               File f = new File(tempname+".jpg");
               f.createNewFile(); //파일 생성
               
               try(OutputStream outputStream=new FileOutputStream(f)){
               while((read=is.read()) != -1) {
                  outputStream.write(bytes); // 1024씩 바이트 코드로 변환
               }
            } 
               
               is.close();
               
            }else { //에러 발생
               br = new BufferedReader(new InputStreamReader(con.getErrorStream()));

                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static final String API_URL = "https://maps.apigw.ntruss.com/map-geocode/v2/geocode";   
   private static final String CLIENT_ID = "4uvs2g5ckm";
   private static final String CLIENT_SECRET = "SYwdP2YMcMtMOIXpKSS8wQwbRkumWx2BoFxMhbRV";
   
   public static void main(String[] args) {
      
      try {
         
         BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("주소를 입력하세요 : "); //서울특별시 종로구 종로12길 15
         String address = io.readLine();
         String query = URLEncoder.encode(address, "UTF-8");
         //https://maps.apigw.ntruss.com/map-geocode/v2/geocode?query
         URL url = new URL(API_URL + "?query=" + query);
         
         //인터넷 접속
         HttpURLConnection con = (HttpURLConnection) url.openConnection();
         con.setRequestMethod("GET");
         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
         con.setRequestProperty("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
         con.setRequestProperty("Accept", "application/json");
         
         int responseCode = con.getResponseCode();
         BufferedReader br = new BufferedReader(new InputStreamReader(
               (responseCode == 200) ? con.getInputStream() : con.getErrorStream(), "UTF-8"));
         
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = br.readLine()) != null) {
            sb.append(line);
         }
         br.close();
         con.disconnect();
         
         String json = sb.toString();
         //System.out.println("Response ("+ responseCode+ "): " + json);
         
         if (responseCode == 200) {
            JSONObject object = new JSONObject(json);
            JSONArray addresses = object.getJSONArray("addresses");
            if(addresses.length() > 0) {
               JSONObject addr = addresses.getJSONObject(0);
               System.out.println("도로명 주소: " + addr.getString("roadAddress"));
               System.out.println("지번 주소: " + addr.getString("jibunAddress"));
               System.out.println("경도(x): " + addr.getString("x"));
               System.out.println("위도(y): " + addr.getString("y"));
               
               String x = addr.getString("x");
               String y = addr.getString("y");
               map_service(x,y,address);
               System.out.println("지도 이미지가 생성되었습니다.");
               
            }else {
               System.out.println("검색 결과가 없습니다.");
            }
         }else {
               System.out.println("API 오류: " + json);
            }
                     
         
         
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
