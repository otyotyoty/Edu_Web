package kr.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_C {

	private static final String API_URL = "https://maps.apigw.ntruss.com/map-geocode/v2/geocode";
	private static final String CLIENT_ID = "q1bp1mt1wm";
	private static final String CLIENT_SECRET = "QzyPpJFbkdVYdHVfEAK3qUmORXGAungCPSIKe9UQ";
	
	public static void main(String[] args) {
		
		try {
			BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("주소를 입력하세요 : "); //서울특별시 종로구 종로12길 15
			String address = io.readLine();
			String query = URLEncoder.encode(address, "UTF-8"); //URL에서 인지하도록 URL로 형변환
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
			
			if (responseCode == 200) {
			    JSONObject object = new JSONObject(json);
			    JSONArray addresses = object.getJSONArray("addresses");
			    if (addresses.length() > 0) {
			        JSONObject addr = addresses.getJSONObject(0);
			        System.out.println("도로명 주소: " + addr.getString("roadAddress"));
			        System.out.println("지번 주소: " + addr.getString("jibunAddress"));
			        System.out.println("경도(x): " + addr.getString("x"));
			        System.out.println("위도(y): " + addr.getString("y"));
			    } else {
			        System.out.println("검색 결과가 없습니다.");
			    }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
