package shoppingServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Customer;
import com.glp.domain.Product;
import com.glp.service.CustomerService;
import com.glp.service.MyCart;
import com.glp.util.SqlHelper;

public class GoMyOrder extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		MyCart myCart=(MyCart) request.getSession().getAttribute("myCart");
		ArrayList al=myCart.showMyCart();
		float totalPrice=myCart.getTotalPrice();		
		request.setAttribute("orderinfo", al);
		request.setAttribute("totalPrice", totalPrice);
		
		request.getRequestDispatcher("/showMyOrder.jsp").forward(request, response);		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
