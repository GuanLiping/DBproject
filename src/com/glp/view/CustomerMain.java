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
import com.glp.domain.Customer;
import com.glp.domain.Supplier;
import com.glp.service.CustomerService;
import com.glp.service.MyCart;
import com.glp.service.SupplierService;


public class CustomerMain extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
        HttpSession session=request.getSession();
        MyCart myCart=new MyCart();
		request.getSession().setAttribute("myCart", myCart);
		
		String Cid=session.getAttribute("Cid")+"";	
		CustomerService customerService=new CustomerService();		
		Customer customer=customerService.getCustomerById(Cid);
		
		
		session.setAttribute("customer", customer);
		
		String addressID=customer.getAddress_id()+"";	
		Address address=customerService.getAdressById(addressID);
			
		session.setAttribute("CAddress", address);
		
		
		
		out.println("<img src='images/1t.jpg' />Welcome, Customer "+customer.getName()+"!" +
				" <a href ='/DBproject/index.html'>Logout</a><hr/>");
		
		out.println("<h3>Please choose the service</h3>");
		out.println("<a href='/DBproject/ModifyCustomer.jsp'>Modify my information</a><br/>");
		out.println("<a href='/DBproject/hall.jsp'>GO Shopping!</a><br/>");
		out.println("<a href='/DBproject/ViewHistory'>View my purchase history!</a><br/>");
		
		    
	    out.println("<hr/><img src='images/2t.jpg' />"); 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
