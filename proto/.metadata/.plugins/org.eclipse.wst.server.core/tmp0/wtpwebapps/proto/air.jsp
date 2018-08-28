<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"59931",secure:"59937"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/proto/WebContent/air.jsp">
<form action="<%=request.getContextPath()%>/air?cmd=air_view" method="POST" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/proto/WebContent/air.jsp">
항공사
<select name="airline">
	<option><항공사를 선택해주세요></option>
	<option value="AAR">아시아나</option>
	<option value="ABL">에어부산</option>
	<option value="ESR">이스타</option>
	<option value="JJA">제주항공</option>
	<option value="JNA">진에어</option>
	<option value="KAL">대한항공</option>
	<option value="TWB">티웨이항공</option>
</select>
출발공항
<select name="depairport">
	<option><공항을 선택해주세요></option>
	<option value="NAARKJB">무안</option>
	<option value="NAARKJJ">광주</option>
	<option value="NAARKJK">군산</option>
	<option value="NAARKJY">여수</option>
	<option value="NAARKNW">원주</option>
	<option value="NAARKNY">양양</option>
	<option value="NAARKPC">제주</option>
	<option value="NAARKPK">김해</option>
	<option value="NAARKPS">사천</option>
	<option value="NAARKPU">울산</option>
	<option value="NAARKSI">인천</option>
	<option value="NAARKSS">김포</option>
	<option value="NAARKTH">포항</option>
	<option value="NAARKTN">대구</option>
	<option value="NAARKTU">청주</option>
</select>
도착공항
<select name="arrairport">
	<option><공항을 선택해주세요></option>
	<option value="NAARKJB">무안</option>
	<option value="NAARKJJ">광주</option>
	<option value="NAARKJK">군산</option>
	<option value="NAARKJY">여수</option>
	<option value="NAARKNW">원주</option>
	<option value="NAARKNY">양양</option>
	<option value="NAARKPC">제주</option>
	<option value="NAARKPK">김해</option>
	<option value="NAARKPS">사천</option>
	<option value="NAARKPU">울산</option>
	<option value="NAARKSI">인천</option>
	<option value="NAARKSS">김포</option>
	<option value="NAARKTH">포항</option>
	<option value="NAARKTN">대구</option>
	<option value="NAARKTU">청주</option>
</select>
출발날짜 <input type="text" name="depdate" required> <button>검색</button>
도착날짜 <input type="text" name="depdate2"> <button>검색</button>
</form>
</body>
</html>