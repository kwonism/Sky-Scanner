package com.proto.aircontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proto.action.Action;
import com.proto.dao.AirDAO;
import com.proto.dto.AirVO;

public class AirViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "air/viewPage.jsp";

		AirDAO adao = new AirDAO();

		String airline = request.getParameter("airline");
		String depairport = request.getParameter("depairport");
		String arrairport = request.getParameter("arrairport");
		String depdate = request.getParameter("depdate");
		AirVO avo = new AirVO();
		avo.setAirlineNm(airline);
		avo.setDepAirportNm(depairport);
		avo.setArrAirportNm(arrairport);
		avo.setDepPlandTime(depdate);
		List<AirVO> air = adao.selectAir(avo);
		// 스크립트 방어
		request.setAttribute("air", air);
		
		if(request.getParameter("depdate2") != null) {
			avo.setDepAirportNm(arrairport);
			avo.setArrAirportNm(depairport);
			avo.setDepPlandTime(request.getParameter("depdate2"));
			List<AirVO> air2 = adao.selectAir(avo);
			request.setAttribute("air2", air2);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
}
