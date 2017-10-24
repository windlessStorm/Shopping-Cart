package com.pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Abcd")
public class Abcd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String player1=request.getParameter("p1");
		String player2=request.getParameter("p2");
		HttpSession hs=request.getSession();
		hs.setAttribute("Play1", player1);
		hs.setAttribute("Play2", player2);
		char t[][]=new char[3][3];
		hs.setAttribute("session_array", t);
		hs.setAttribute("player_name", player1);
		hs.setAttribute("flag","1");
		response.sendRedirect("Play.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
