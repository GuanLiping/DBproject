package com.glp.tableService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glp.service.ManagerService;
import com.glp.util.SqlHelper;

/**
 * Servlet implementation class ModifyProduct
 */
@WebServlet("/ModifyProduct")
public class ModifyProduct extends HttpServlet {
	
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		
		
		String[] productId=request.getParameterValues("id");
		String[] productNum=request.getParameterValues("productNum");
		
		
		
		 try{
	    	  ct=SqlHelper.getConnection();	    	  
	    	  ct.setAutoCommit(false);
	    	     	  
	    	  for(int i=0;i<productId.length;i++){
	    	  
	    	  String sql="UPDATE Product SET number='"+productNum[i]+"' WHERE id ='"+productId[i]+"' ";
	    	  ps=ct.prepareStatement(sql);
	    	  ps.executeUpdate();
	    	  
	    	  ct.commit();
	    	  
	    		}
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
   	  
		
		
		request.getRequestDispatcher("/ManagerMain").forward(request, response);
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
