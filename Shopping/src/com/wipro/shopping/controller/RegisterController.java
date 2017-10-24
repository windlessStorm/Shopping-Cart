package com.wipro.shopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.shopping.bean.UserBean;
import com.wipro.shopping.dao.RegisterDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username, password, name, email, city, usertype;
		HttpSession session = request.getSession();
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		name = request.getParameter("name");
		email = request.getParameter("email");
		city = request.getParameter("city");
		usertype = request.getParameter("usertype");
		
		UserBean user_register = new UserBean();
		
		user_register.setUserId(username);
		user_register.setPassword(password);
		user_register.setName(name);
		user_register.setEmail(email);
		user_register.setCity(city);
		user_register.setUserType(usertype);
		
		RegisterDao register = new RegisterDao();
		
		boolean result = register.registerUser(user_register);
		
		if(result)
			session.setAttribute("registration", "success");
		else
			session.setAttribute("registration", "failed");
		response.sendRedirect("register.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
