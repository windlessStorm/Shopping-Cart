package com.wipro.shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.shopping.bean.MobileBean;
import com.wipro.shopping.dao.AddDao;

/**
 * Servlet implementation class ModifyMobileController
 */
@WebServlet("/ModifyMobileController")
public class ModifyMobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean modify_entry;
		String old_model_number,new_model_number,model_name,price_str;
		int price=0;
		HttpSession session = request.getSession();
		AddDao modify_mobile = new AddDao();
		MobileBean mobile_modify = new MobileBean();
		
		old_model_number = request.getParameter("old_model_number");
		new_model_number = request.getParameter("new_model_number");
		model_name = request.getParameter("model_name");
		price_str = request.getParameter("price");
		if(price_str!=null)
			price = Integer.parseInt(price_str);
		
		mobile_modify.setModelNumber(new_model_number);
		mobile_modify.setModelName(model_name);
		mobile_modify.setPrice(price);
		
		if((String)session.getAttribute("modify_mobile") != null)
		{
			modify_entry = modify_mobile.modifyMobile(old_model_number, mobile_modify);
			if(modify_entry)
				session.removeAttribute("modify_mobile");
		}
		else
		{
			session.setAttribute("modify_mobile", old_model_number);
		}
		
		response.sendRedirect("ModifyItem.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
