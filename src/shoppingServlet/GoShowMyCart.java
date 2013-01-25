package shoppingServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glp.service.MyCart;


public class GoShowMyCart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		MyCart myCart=(MyCart) request.getSession().getAttribute("myCart");
		
		request.setAttribute("totalPrice", myCart.getTotalPrice());
		request.setAttribute("productList", myCart.showMyCart());
		request.getRequestDispatcher("/showMyCart.jsp").forward(request, response);
		//为了防止某个页面刷新    
		//response.sendRedirect("/WEB-INF/showMyCart.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
