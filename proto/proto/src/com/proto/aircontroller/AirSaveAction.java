package com.proto.aircontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proto.action.Action;
import com.proto.dao.AirDAO;
import com.proto.dto.AirVO;

public class AirSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "air/viewPage2.jsp";
		HttpSession session = request.getSession();
		List<AirVO> list = (List)session.getAttribute("air2");
		
		AirVO avo = new AirVO();
		String airline = request.getParameter("airline");
		String depairport = request.getParameter("depairport");
		String arrairport = request.getParameter("arrairport");
		String deptime = request.getParameter("deptime");
		String arrtime = request.getParameter("arrtime");
		String economy = request.getParameter("economy");
		String prestige = request.getParameter("prestige");
		String vihicle = request.getParameter("vihicle");
		
		avo.setAirlineNm(airline);
		avo.setDepAirportNm(depairport);
		avo.setArrAirportNm(arrairport);
		avo.setDepPlandTime(deptime);
		avo.setArrPlandTime(arrtime);
		avo.setEconomyCharge(economy);
		avo.setPrestigeCharge(prestige);
		avo.setVihicleId(vihicle);
		
		request.setAttribute("save", avo);
		request.setAttribute("air2", list);
		session.removeAttribute("air2");

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}
}
