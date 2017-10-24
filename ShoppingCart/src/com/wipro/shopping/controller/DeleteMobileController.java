package com.wipro.shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.shopping.dao.AddDao;

/**
 * Servlet implementation class DeleteMobileController
 */
@WebServlet("/DeleteMobileController")
public class DeleteMobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMobileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String modelNumber;
		HttpSession session = request.getSession();
		
		modelNumber = request.getParameter("modelnumber");
		AddDao delete = new AddDao();
		boolean flag = delete.deletemobile(modelNumber);
		
		if(flag)
			session.setAttribute("delete", "success");
		else
			session.setAttribute("delete", "fail");
		response.sendRedirect("DeleteItem.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
