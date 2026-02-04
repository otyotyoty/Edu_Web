package javaapi;

import java.io.*;
import java.net.*;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.*;

@WebServlet("/MapServlet")
public class MapServlet extends HttpServlet {

	private static final String GEOCODE_URL = "https://maps.apigw.ntruss.com/map-geocode/v2/geocode";
	private static final String STATICMAP_URL = "https://maps.apigw.ntruss.com/map-static/v2/raster?";
	private static final String CLIENT_ID = "q1bp1mt1wm";
	private static final String CLIENT_SECRET = "QzyPpJFbkdVYdHVfEAK3qUmORXGAungCPSIKe9UQ";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("map.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String address = request.getParameter("address");

		try {
			// 1단계: 주소 → 좌표 변환
			String query = URLEncoder.encode(address, "UTF-8");
			URL url = new URL(GEOCODE_URL + "?query=" + query);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
			con.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();

			// JSON 파싱
			JSONObject object = new JSONObject(sb.toString());
			JSONArray addresses = object.getJSONArray("addresses");

			if (addresses.length() > 0) {
				JSONObject addr = addresses.getJSONObject(0);
				String x = addr.getString("x"); // 경도
				String y = addr.getString("y"); // 위도
				String roadAddress = addr.getString("roadAddress");
				String jibunAddress = addr.getString("jibunAddress");

				// 2단계: 좌표 → 지도 이미지 생성
				String imageName = createMapImage(x, y, address);

				// JSP로 데이터 전달
				request.setAttribute("roadAddress", roadAddress);
				request.setAttribute("jibunAddress", jibunAddress);
				request.setAttribute("x", x);
				request.setAttribute("y", y);
				request.setAttribute("imageName", imageName);
				request.setAttribute("success", true);

			} else {
				request.setAttribute("success", false);
				request.setAttribute("message", "검색 결과가 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("success", false);
			request.setAttribute("message", "오류 발생: " + e.getMessage());
		}

		RequestDispatcher rd = request.getRequestDispatcher("map.jsp");
		rd.forward(request, response);
	}

	// 지도 이미지 생성 메서드
	private String createMapImage(String x, String y, String address) throws Exception {
        
        String pos = URLEncoder.encode(x + " " + y, "UTF-8");
        String mapUrl = STATICMAP_URL;
        mapUrl += "center=" + x + "," + y;
        mapUrl += "&level=16&w=700&h=500";
        mapUrl += "&markers=type:t|size:mid|pos:" + pos + "|label:" + 
                  URLEncoder.encode(address, "UTF-8");
        
        URL u = new URL(mapUrl);
        HttpsURLConnection con = (HttpsURLConnection) u.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
        con.setRequestProperty("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
        
        int responseCode = con.getResponseCode();
        
        if (responseCode == 200) {
            InputStream is = con.getInputStream();
            
            // 고유한 파일명 생성
            String fileName = "map_" + System.currentTimeMillis() + ".jpg";
            
            // WebContent/images 폴더에 저장 (웹에서 접근 가능)
            String realPath = getServletContext().getRealPath("/images");
            File folder = new File(realPath);
            if (!folder.exists()) {
                folder.mkdirs(); // 폴더가 없으면 생성
            }
            
            File outputFile = new File(realPath, fileName);
            
            try (OutputStream os = new FileOutputStream(outputFile)) {
                byte[] buffer = new byte[1024];
                int read;
                while ((read = is.read(buffer)) != -1) {
                    os.write(buffer, 0, read);
                }
            }
            
            is.close();
            con.disconnect();
            
            return fileName; // 파일명만 반환
            
        } else {
            throw new Exception("지도 이미지 생성 실패: " + responseCode);
        }
    }
}