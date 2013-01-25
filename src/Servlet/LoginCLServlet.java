package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Customer;
import com.glp.domain.Manager;
import com.glp.domain.Supplier;
import com.glp.service.ManagerService;


public class LoginCLServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String choice=request.getParameter("choice");
		String id=request.getParameter("id");
	    String password=request.getParameter("password");
	   
	   
	    if(id!=null&&id!=""&&password!=null&&password!=""){
	    
	    if("customer".equals(choice)){
	    	
	    ManagerService managerservice=new ManagerService();		  
	    Customer customer=new Customer();		
	    customer.setId(Integer.parseInt(id));
	    customer.setpassword(password);
		
			if(managerservice.checkCustomer(customer)){
			
				session.setAttribute("Cid", id);
				request.getRequestDispatcher("/CustomerMain").forward(request, response);
				
				
			}else{
				
				request.getRequestDispatcher("/error.html").forward(request, response);
			}
			
	    }else if("supplier".equals(choice)){
	    	
	    	Supplier supplier=new Supplier();
	    	ManagerService managerservice=new ManagerService();
	    	supplier.setId(Integer.parseInt(id));
	    	supplier.setPassword(password);
	    	
	    	if(managerservice.checkSupplier(supplier)){
	    		
	    		session.setAttribute("Sid", id);
	    		request.getRequestDispatcher("/SupplierMain").forward(request, response); 
				
			}else{
				
				request.getRequestDispatcher("/error.html").forward(request, response);
			}
	    	
	    	
	    	
	    }else if("manager".equals(choice)){
	    	
	    	Manager manager=new Manager();
	    	ManagerService managerservice=new ManagerService();
	    	manager.setId(Integer.parseInt(id));
	    	manager.setPassword(password);
	    	
            if(managerservice.checkManager(manager)){
				
            	request.getRequestDispatcher("/ManagerMain").forward(request, response); 
				
			}else{
				
				request.getRequestDispatcher("/error.html").forward(request, response);
			}
	    	
	    	
	    }
	    
	    }else{
	    	request.getRequestDispatcher("/error.html").forward(request, response);
	    }
	    
	   	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
