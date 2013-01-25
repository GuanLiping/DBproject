package com.glp.tableService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Supplier;
import com.glp.service.SupplierService;

/**
 * Servlet implementation class searchSupplier
 */
@WebServlet("/searchSupplier")
public class searchSupplier extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		SupplierService supplierService=new SupplierService();
		Supplier supplier=supplierService.getSupplierById(id);
		
		HttpSession session=request.getSession();
		session.setAttribute("supplier", supplier);
		
		 request.getRequestDispatcher("/SearchSupplier.jsp").forward(request, response); 
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
