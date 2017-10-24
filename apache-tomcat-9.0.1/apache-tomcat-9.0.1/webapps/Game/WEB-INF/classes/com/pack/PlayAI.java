package com.pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PlayAI")
public class PlayAI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicTac tic=new TicTac();
	int z=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs=request.getSession();
		String p1=(String)hs.getAttribute("P1");
		String p2=(String)hs.getAttribute("AI");
		String r=request.getParameter("a");
		int play=Integer.parseInt(r);
		response.setContentType("text/html");
		
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
			
		//z++;
			if(z%2!=0)
				hs.setAttribute("ai_name", p2);
			else
				hs.setAttribute("player_name", p1);
		if(z<10)	
				play(request,response,ro,co);		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs=request.getSession();
		String p1=(String)hs.getAttribute("P1");
		tic.refresh();
		z=0;
		hs.setAttribute("player_name",p1);
		response.sendRedirect("PVA.jsp");
		
	}
	void play(HttpServletRequest request, HttpServletResponse response, int ro, int co) throws IOException
	{
		HttpSession hs=request.getSession();
		String p1=(String)hs.getAttribute("P1");
		String p2=(String)hs.getAttribute("AI");
		int flag=0,flag2=0;
		flag=tic.insertAI(ro, co);
		hs.setAttribute("flagP", flag);
		if(flag==1)
		{
			z++;
			if(z%2!=0)
				hs.setAttribute("ai_name",p2);
			else
				hs.setAttribute("player_name", p1);
			flag2=tic.move();
		}
		/*else if(flag2==0)
		{
			response.sendRedirect("DrawPVA.jsp");
		}*/
		//flag2=tic.move();
		if(flag==0)
		{
			z=z-1;
			if(z%2!=0)
				hs.setAttribute("ai_name",p2);
			else
				hs.setAttribute("player_name", p1);
				
				char[][] arr = tic.t;
				hs.setAttribute("Ar",arr);
				response.sendRedirect("PVA.jsp");
			//pw.print("<body bgcolor=Red>Invalid Location..<a href=PVA.jsp>Go Back</a></body>");
		}
		else if(flag2==1)
		{
			z++;
			if(z%2!=0)
				hs.setAttribute("ai_name",p2);
			else
				hs.setAttribute("player_name", p1);
		}
		
		if(z>4)
		{
			int[] ch=tic.checkIt();
			hs.setAttribute("line", ch[0]);
			if(ch[1]==1)
			{
				response.sendRedirect("WinP.jsp");
				z=10;
			}
			else if(ch[1]==2)
			{
				response.sendRedirect("WinAI.jsp");
				z=10;
			}
			else if(z==9)
				response.sendRedirect("DrawPVA.jsp");
			else
			{ 
				char[][] arr = tic.t;
				hs.setAttribute("Ar",arr);
				response.sendRedirect("PVA.jsp");
			}
		}
		else
		{
			char[][] arr = tic.t;
			hs.setAttribute("Ar",arr);
			response.sendRedirect("PVA.jsp");
		}
	}

}
