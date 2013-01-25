package shoppingServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glp.service.MyCart;

/**
 * Servlet implementation class ShoppingCl
 */
@WebServlet("/ShoppingCl")
public class ShoppingCl extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		String type=request.getParameter("type");
		
		if("add".equals(type)){
			MyCart myCart=(MyCart) request.getSession().getAttribute("myCart");
			//ȡ�����ﳵ ������鵽���ﳵ
			
			String id=request.getParameter("id");
			myCart.addProduct2(id);		
			
			response.sendRedirect("/DBproject/GoShowMyCart");
			
			}
		else if("del".equals(type)){
			MyCart myCart=(MyCart) request.getSession().getAttribute("myCart");
			String id=request.getParameter("id");
			myCart.delProduct(id);
			
			request.setAttribute("totalPrice", myCart.getTotalPrice());
			request.setAttribute("productList", myCart.showMyCart());
			request.getRequestDispatcher("/showMyCart.jsp").forward(request, response);
			//Ϊ�˷�ֹĳ��ҳ��ˢ��    
								
		}
		else if("update".equals(type)){
			MyCart myCart=(MyCart) request.getSession().getAttribute("myCart");
			String productIds[]=request.getParameterValues("id");
			String nums[]=request.getParameterValues("productnum");
			
			for(int i=0;i<productIds.length;i++){
				//�����������ﳵ
				myCart.updateProduct(productIds[i], nums[i]);
			}
			
			request.setAttribute("totalPrice", myCart.getTotalPrice());
			request.setAttribute("productList", myCart.showMyCart());
			request.getRequestDispatcher("/showMyCart.jsp").forward(request, response);
			//Ϊ�˷�ֹĳ��ҳ��ˢ��    		
		}
		
		
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
