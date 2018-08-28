package com.proto.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.proto.dto.AirVO;

public class AirDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<AirVO> selectAir(AirVO avo) throws IOException {
		List<AirVO> list = null;
		JSONArray arr = null;
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=dIVOe6RHE9lDw%2BrRNqpWR1KY7uObCMOZflVA9KGs%2FlIOJoHX%2F1V0em7Eb3rmYRC7zz7IFPhPL9%2BhCrLk%2BpBjBw%3D%3D"); /*
																																 * Service
																																 * Key
																																 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("depAirportId", "UTF-8") + "="
				+ URLEncoder.encode(avo.getDepAirportNm(), "UTF-8")); /* 출발공항ID */
		urlBuilder.append("&" + URLEncoder.encode("arrAirportId", "UTF-8") + "="
				+ URLEncoder.encode(avo.getArrAirportNm(), "UTF-8")); /* 도착공항ID */
		urlBuilder.append("&" + URLEncoder.encode("depPlandTime", "UTF-8") + "="
				+ URLEncoder.encode(avo.getDepPlandTime(), "UTF-8")); /* 출발일 */
		urlBuilder.append("&" + URLEncoder.encode("airlineId", "UTF-8") + "="
				+ URLEncoder.encode(avo.getAirlineNm(), "UTF-8")); /* 항공사ID */
		urlBuilder.append(
				"&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* json */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		// System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		// System.out.println(sb.toString());

		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(sb.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj1 = (JSONObject) obj.get("response");
		JSONObject obj2 = (JSONObject) obj1.get("body");
		if (!(obj2.get("items").equals(""))) {
			JSONObject obj3 = (JSONObject) obj2.get("items");

			arr = (JSONArray) obj3.get("item");
		}

		// System.out.println(arr.toString());
		Gson gson = new Gson();

		/* System.out.println(arr.toString()); */

		try {

			if (arr != null) {
				list = gson.fromJson(arr.toString(), new TypeToken<List<AirVO>>() {}.getType());
				for (int i = 0; i < list.size(); i++) {
					String a = list.get(i).getDepPlandTime().substring(0, 4);
					String b = list.get(i).getDepPlandTime().substring(4, 6);
					String c = list.get(i).getDepPlandTime().substring(6, 8);
					String d = list.get(i).getDepPlandTime().substring(8, 10);
					String e = list.get(i).getDepPlandTime().substring(10, 12);
					list.get(i).setDepPlandTime(a + "년" + b + "월" + c + "일" + d + "시" + e + "분");
				}

				for (int i = 0; i < list.size(); i++) {
					String a = list.get(i).getArrPlandTime().substring(0, 4);
					String b = list.get(i).getArrPlandTime().substring(4, 6);
					String c = list.get(i).getArrPlandTime().substring(6, 8);
					String d = list.get(i).getArrPlandTime().substring(8, 10);
					String e = list.get(i).getArrPlandTime().substring(10, 12);
					list.get(i).setArrPlandTime(a + "년" + b + "월" + c + "일" + d + "시" + e + "분");
				}

				
					for (int i = 0; i < list.size(); i++) {
						int length = list.get(i).getEconomyCharge().length();
						if (length == 5) {
							String a = list.get(i).getEconomyCharge().substring(0, 2);
							String b = list.get(i).getEconomyCharge().substring(2, 5);
							list.get(i).setEconomyCharge(a + "," + b + "원");
						} else if (length == 6) {
							String a = list.get(i).getEconomyCharge().substring(0, 2);
							String b = list.get(i).getEconomyCharge().substring(2, 6);
							list.get(i).setEconomyCharge(a + "," + b + "원");
						}
					}

					for (int i = 0; i < list.size(); i++) {
						String a = null;
						String b = null;
						int length = list.get(i).getPrestigeCharge().length();
						if (length == 5) {
							a = list.get(i).getPrestigeCharge().substring(0, 2);
							b = list.get(i).getPrestigeCharge().substring(2, 5);
						} else if (length == 6) {
							a = list.get(i).getPrestigeCharge().substring(0, 3);
							b = list.get(i).getPrestigeCharge().substring(3, 6);
						}

						list.get(i).setPrestigeCharge(a + "," + b + "원");

					}
				}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
