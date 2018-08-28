<%@page import="com.proto.dto.AirVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "air?air_save";
	List<AirVO> list = (List)request.getAttribute("air2");
	session.setAttribute("air2", list);
%>
가는날 항공편

<c:choose>
	<c:when test="${!empty air}">
	<c:forEach var="item" items="${air}" varStatus="value">
	
		<div>
			<form action="air?cmd=air_save" method="post">
				<input type="hidden" name="airline" value="${item.airlineNm}">
				<input type="hidden" name="depairport" value="${item.depAirportNm}">
				<input type="hidden" name="arrairport" value="${item.arrAirportNm}">
				<input type="hidden" name="deptime" value="${item.depPlandTime}">
				<input type="hidden" name="arrtime" value="${item.arrPlandTime}">
				<input type="hidden" name="economy" value="${item.economyCharge}">
				<input type="hidden" name="prestige" value="${item.prestigeCharge}">
				<input type="hidden" name="vihicle" value="${item.vihicleId}">
				
				<h4 class="card-title">항공사: ${item.airlineNm}</h4>
				<h4 class="card-title">출발공항: ${item.depAirportNm}</h4>
				<h4 class="card-title">도착공항: ${item.arrAirportNm}</h4>
				<h4 class="card-title">출발시간: ${item.depPlandTime}</h4>
				<h4 class="card-title">도착시간: ${item.arrPlandTime}</h4>
				<h4 class="card-title">이코노미: ${item.economyCharge}</h4>
				<h4 class="card-title">비지니스: ${item.prestigeCharge}</h4>
				<h4 class="card-title">항공기번호: ${item.vihicleId}</h4>
				<button>선택</button>
			</form>
		</div>
	---------------------------------------------------------
	</c:forEach>
</c:when>
<c:otherwise>
	검색결과 없음.
</c:otherwise>
</c:choose>

</body>
</html>