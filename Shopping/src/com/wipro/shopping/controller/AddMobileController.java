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
 * Servlet implementation class AddMobileController
 */
@WebServlet("/AddMobileController")
public class AddMobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMobileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String modelNumber, modelName,getPrice;
		int price=0;
		boolean addEntry=false;
		HttpSession session = request.getSession();
		
		modelNumber = request.getParameter("modelnumber");
		modelName = request.getParameter("modelname");
		getPrice = request.getParameter("price");
		if(getPrice!=null)
			price = Integer.parseInt(getPrice);
		
		MobileBean mobile_add = new MobileBean();
		mobile_add.setModelNumber(modelNumber);
		mobile_add.setModelName(modelName);
		mobile_add.setPrice(price);
		
		AddDao addmobile = new AddDao();
		
		addEntry = addmobile.addMobile(mobile_add);
		
		
		if(addEntry)
		{
			response.sendRedirect("AddItem.jsp");
			session.setAttribute("addentry", "success");			
		}
		else
		{
			response.sendRedirect("AddItem.jsp");
			session.setAttribute("addentry", "failed");
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
