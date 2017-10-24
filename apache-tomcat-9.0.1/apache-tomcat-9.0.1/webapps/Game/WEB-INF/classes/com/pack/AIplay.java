package com.pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AIplay")
public class AIplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pn=request.getParameter("N");
			String an=request.getParameter("A");
			
			HttpSession s=request.getSession();
			s.setAttribute("P1", pn);
			s.setAttribute("AI", an);
			char t[][]=new char[3][3];
			s.setAttribute("Ar", t);
			s.setAttribute("player_name", pn);
			s.setAttribute("flagP", "1");
			response.sendRedirect("PVA.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
