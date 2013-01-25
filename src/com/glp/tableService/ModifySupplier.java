package com.glp.tableService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glp.util.SqlHelper;

/**
 * Servlet implementation class ModifySupplier
 */
@WebServlet("/ModifySupplier")
public class ModifySupplier extends HttpServlet {
	
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		  String id=request.getParameter("id");
		  String name=request.getParameter("name");
	      String password=request.getParameter("password");    
	      String phone_number=request.getParameter("phone_number"); 
	      String email=request.getParameter("email");
	      
	      //System.out.println(id);
	      //System.out.println(name);
	      // System.out.println(password);
		  int address_id=0;
		  String street=request.getParameter("street");
		  String zip_code=request.getParameter("zip_code");
		  String city=request.getParameter("city");
		  String country=request.getParameter("country");
		  
		  String sqlS="UPDATE Supplier SET name='"+name+"',password='"+password+"',phone_number='"+phone_number+"',email='"+email+"' WHERE id ='"+id+"'";
		  String sql="select address_id from Supplier where id='"+id+"'";	  
		 
		  
		  
			 try{
		    	  ct=SqlHelper.getConnection();	    	  
		    	  ct.setAutoCommit(false);
		    	     
		    	  
		    	  ps=ct.prepareStatement(sql);
		    	  rs=ps.executeQuery();    		    	  
		    	  if(rs.next()){    		  
		    		  address_id=rs.getInt(1);	    		 
		    	  } 
		    	  
		    	  
		    	  ps=ct.prepareStatement(sqlS);		    	    	  
		    	  ps.executeUpdate();
		    	  
		    	
 String sqlA="UPDATE Address SET street='"+street+"',zip_code='"+zip_code+"',city='"+city+"',country='"+country+"' WHERE id='"+address_id+"'";
					
		    	  ps=ct.prepareStatement(sqlA); 	  
		    	  ps.executeUpdate(); 	    	  
		    	  
		    	  ct.commit();
		    	  
		    		
	   	  }catch(Exception e){    		  
	   		  try {
					ct.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	   		  throw new RuntimeException(e.getMessage());
	   	  }finally{
	   		  SqlHelper.close(rs, ps, ct);
	   	  }
			 
			 request.getRequestDispatcher("/SupplierMain").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
