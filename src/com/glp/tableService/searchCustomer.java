package com.glp.tableService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Customer;
import com.glp.domain.Supplier;
import com.glp.service.CustomerService;
import com.glp.service.SupplierService;

/**
 * Servlet implementation class searchCustomer
 */
@WebServlet("/searchCustomer")
public class searchCustomer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		CustomerService customerService=new CustomerService();
		Customer customer= customerService.getCustomerById(id);
		
		HttpSession session=request.getSession();
		session.setAttribute("customer", customer);
		
		 request.getRequestDispatcher("/SearchCustomer.jsp").forward(request, response); 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
