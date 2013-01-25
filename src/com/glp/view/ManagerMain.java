package com.glp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Product;
import com.glp.service.ManagerService;


public class ManagerMain extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		
		
		
		out.println("<img src='images/1t.jpg' />Welcome, Manager!" +
				" <a href ='/DBproject/index.html'>Logout</a><hr/>");
		
		out.println("<h3>Please choose the service</h3>");
		out.println("<a href='/DBproject/ManagerCustomer'>Manage Customer</a><br/>");
		out.println("<a href='/DBproject/ManagerSupplier'>Manage Supplier</a><br/>");
		out.println("<a href='/DBproject/ModifyProduct.jsp'>Update Product Numbers</a><br/>");
		
	    
	   	    
	    out.println("<hr/><img src='images/2t.jpg' />");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
