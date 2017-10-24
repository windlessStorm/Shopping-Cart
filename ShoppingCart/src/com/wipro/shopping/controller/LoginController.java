package com.wipro.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Index;

import com.wipro.shopping.bean.UserBean;
import com.wipro.shopping.dao.LoginDao;
import com.wipro.shopping.util.DBUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean validUser,userAccess;
		String username,password;
		HttpSession hs=request.getSession();
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		UserBean user_login = new UserBean();
		
		user_login.setUserId(username);
		user_login.setPassword(password);
		
		LoginDao login = new LoginDao();
		
		validUser = login.validUser(user_login);
		if(validUser)
		{
			userAccess = login.userAccess(user_login);

			hs.setAttribute("username", username);
			hs.setAttribute("password", password);

			if(userAccess)
				response.sendRedirect("AdminPage.jsp");
			else	
				response.sendRedirect("UserPage.jsp");
			
		}
		else
		{
			hs.setAttribute("authentication", "failed");
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
