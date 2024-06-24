package com.neo.byez.service.user;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NaverService {

    String accessToken = "";

    public String getAccessTokenFromNaver(String code, String state) {
        try {
            String clientId = "nV14togkwJUZVzs2_YnF"; // 애플리케이션 클라이언트 아이디
            String clientSecret = "1a5W8ZmL5I"; // 애플리케이션 클라이언트 시크릿값
            String redirectURI = URLEncoder.encode("http://localhost:8080/naverLogin", "UTF-8");
            String apiURL;
            apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
            apiURL += "client_id=" + clientId;
            apiURL += "&client_secret=" + clientSecret;
            apiURL += "&redirect_uri=" + redirectURI;
            apiURL += "&code=" + code;
            apiURL += "&state=" + state;

            URL url = new URL(apiURL); // URL 객체 생성
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // HTTP 연결
            conn.setRequestMethod("GET"); // Access Token 요청 위해 client_id, code 를 네이버 서버로 전송

            int responseCode = conn.getResponseCode();
            BufferedReader br;

            // 정상 호출
            if(responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            // 에러 발생
            else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            String inputLine;
            StringBuffer respBr = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                respBr.append(inputLine);
            }
            br.close();

            // 정규식 패턴 생성 후 패턴의 매칭 결과 확인하여 result 문자열을 잘라서 토큰값만 저장하고자 함.
            Pattern pattern = Pattern.compile("\"access_token\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(respBr);

            if (matcher.find()) {
                // 첫 번째 그룹에서 매칭된 값 가져오기
                // => matcher.group(0); <- access_token 들어간 문장 전체 반환
                accessToken = matcher.group(1); // access token 값만 반환
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return accessToken;
    }

    public String getUserNickname(String accessToken) {
        String nickname = "";
        try {
            String token = accessToken; // 네이버 로그인 접근 토큰;
            String header = "Bearer " + token; // Bearer 다음에 공백 추가

            String apiURL = "https://openapi.naver.com/v1/nid/me";

            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("Authorization", header);
            String responseBody = get(apiURL, requestHeaders);

            // JSON 파싱
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(responseBody);
            JSONObject response = (JSONObject) jsonObj.get("response");
            nickname = (String) response.get("nickname");

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return nickname;
    }

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
