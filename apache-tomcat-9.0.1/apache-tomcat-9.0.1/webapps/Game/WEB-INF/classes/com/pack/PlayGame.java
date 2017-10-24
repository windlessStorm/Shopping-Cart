package com.pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PlayGame")
public class PlayGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicTac tic=new TicTac();
	int z=0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs=request.getSession();
		String p1=(String)hs.getAttribute("Play1");
		String p2=(String)hs.getAttribute("Play2");
		String r=request.getParameter("a");
		int play=Integer.parseInt(r);
		int ro=0,co=0;
		switch(play)
		{
			case 1:ro=0;co=0;
				break;
			case 2:ro=0;co=1;
				break;
			case 3:ro=0;co=2;
				break;
			case 4:ro=1;co=0;
				break;
			case 5:ro=1;co=1;
				break;
			case 6:ro=1;co=2;
				break;
			case 7:ro=2;co=0;
				break;
			case 8:ro=2;co=1;
				break;
			case 9:ro=2;co=2;
				break;
		}
	
			z++;
			if(z%2==0)
				hs.setAttribute("player_name", p1);
			else
				hs.setAttribute("player_name", p2);
			if(z<10)	
				play(request,response,ro,co);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs=request.getSession();
		String p1=(String)hs.getAttribute("Play1");
		tic.refresh();
		z=0;
		hs.setAttribute("player_name", p1);
		response.sendRedirect("Play.jsp");
		
	}
	void play(HttpServletRequest request, HttpServletResponse response, int ro, int co) throws IOException
	{
		HttpSession hs=request.getSession();
		String p1=(String)hs.getAttribute("Play1");
		String p2=(String)hs.getAttribute("Play2");
		
		int flag1;
		flag1=tic.insert(ro, co, z);
		hs.setAttribute("flag",flag1);
		if(flag1==0)
		{
			z=z-1;
			if(z%2==0)
				hs.setAttribute("player_name",p1 );
			else
				hs.setAttribute("player_name", p2);
			 char[][] arr = tic.t;
			 hs.setAttribute("session_array",arr);
			
			 response.sendRedirect("Play.jsp");
		}
		else if(z>4)
		{
			int[] ch=tic.checkIt();
			hs.setAttribute("line", ch[0]);
			if(ch[1]==1)
			{
				response.sendRedirect("WinPL1.jsp");
			}
			else if(ch[1]==2)
			{
				response.sendRedirect("WinPL2.jsp");
				z=10;
			}
			else if(z==9)
			{
				response.sendRedirect("DrawPVP.jsp");
			}
			
			else
			{ 
				char[][] arr = tic.t;
				hs.setAttribute("session_array",arr);
				response.sendRedirect("Play.jsp");
			}
		}
		else
		{
			 char[][] arr = tic.t;
			 hs.setAttribute("session_array",arr);
			 response.sendRedirect("Play.jsp");
		 
		}

	}

}
