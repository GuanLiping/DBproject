package com.glp.tableService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerSupplier
 */
@WebServlet("/ManagerSupplier")
public class ManagerSupplier extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		out.println("<img src='images/1t.jpg' />Welcome, Manager!" +
				" <a href ='/DBproject/index.html'>Logout</a><hr/>");
		
		out.println("<h3>Please choose the service</h3>");
		out.println("<a href='/DBproject/ViewAllSupplier.jsp'>View Suppliers information</a><br/>");
		out.println("<a href='/DBproject/SearchSupplier.html'>Search Supplier By ID</a><br/><br/>");
		
		out.println("<center><a href='/DBproject/ManagerMain'>Back to Manager Main Page</a><center>");
	    out.println("<hr/><img src='images/2t.jpg' />");
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
