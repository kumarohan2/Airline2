package com.lti.flight;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		FlightDao dao = new FlightDao();
		List<Flight> flights =  dao.searchFlight(from, to);
		
		System.out.println(flights);
		
		ObjectMapper mapper = new ObjectMapper();
		String productsJSON = mapper.writeValueAsString(flights);
		
		response.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
		response.setHeader("Access-Control-Allow-Methods","GET");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(productsJSON);	
	}

}
