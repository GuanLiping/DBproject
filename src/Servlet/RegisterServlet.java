package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		String chioce=request.getParameter("choice");
		
		
		if("customer".equals(chioce)){
			request.getRequestDispatcher("/customer.html").forward(request, response);
		}else if("supplier".equals(chioce)){
			request.getRequestDispatcher("/supplier.html").forward(request, response);
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
