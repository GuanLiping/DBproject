package com.glp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Address;
import com.glp.domain.Supplier;
import com.glp.service.SupplierService;


public class SupplierMain extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String Sid=session.getAttribute("Sid")+"";	
		SupplierService supplierService=new SupplierService();		
		Supplier supplier=supplierService.getSupplierById(Sid);
		
		
		session.setAttribute("supplier", supplier);
		
		String addressID=supplier.getAddress_id()+"";	
		Address address=supplierService.getAdressById(addressID);
			
		session.setAttribute("SAddress", address);
		
		out.println("<img src='images/1t.jpg' />Welcome, Supplier "+supplier.getName()+"!" +
				" <a href ='/DBproject/index.html'>Logout</a><hr/>");
		
		out.println("<h3>Please choose the service</h3>");
		out.println("<a href='/DBproject/SViewInformaiton.jsp'>View my information</a><br/>");
		out.println("<a href='/DBproject/ModifySupplier.jsp'>Modify my information</a><br/>");
		out.println("<a href='/DBproject/SViewProduct.jsp'>View my Product</a><br/>");
		    
	    out.println("<hr/><img src='images/2t.jpg' />"); 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
