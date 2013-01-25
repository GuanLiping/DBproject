package shoppingServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.service.MyCart;
import com.glp.util.SqlHelper;


public class ViewHistory extends HttpServlet {
	
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
        
		HttpSession session=request.getSession();		
		String Cid=session.getAttribute("Cid")+"";
		
		
		
		String sql1="select * from PurchaseHistory where customer_id="+Cid;
		String sqlN="SELECT COUNT(*) FROM PurchaseHistory where customer_id="+Cid;

		int n=0;
		int m=0;
		
		String date = null,price = null,name = null,unit_price = null,description = null,purchase_number = null;
		
		response.setContentType("text/html");
	    out=response.getWriter();

		out.println("<h2>My Purchase history Information</h2>");
		out.println("<html>");
		out.println("<body>");
		
		try {
		
			  ct=SqlHelper.getConnection();	    	  
	    	  ct.setAutoCommit(false);
	       	 
	    	  ps=ct.prepareStatement(sqlN);
	    	  rs=ps.executeQuery();    	 
	    	  if(rs.next()){    		  
	    		  n=rs.getInt(1);   		 
	    	  }
	    	  
		
	    	  ps=ct.prepareStatement(sql1);
	    	  rs=ps.executeQuery();   
	    	  String[] arr=new String[n];
	    	  List list1 = new ArrayList();   	  
	    	  while(rs.next()){
	    		  list1.add(rs.getString("orders_id"));	    			
	    	    }
	    	  
	    	  
	    	  for (int i = 0;i<list1.size();i++) {
	    		arr[i]= list1.get(i).toString();
	    		    		
	    		String sql2="select order_date from Orders where id="+arr[i];
	    		 ps=ct.prepareStatement(sql2);
		    	 rs=ps.executeQuery();
		    	 if(rs.next()){    		  
		    		 date=rs.getString(1);   		 
		    	  }
		    	 
		    	 String sql3="select price from Orders where id="+arr[i];
	    		 ps=ct.prepareStatement(sql3);
		    	 rs=ps.executeQuery();
		    	 if(rs.next()){    		  
		    		 price=rs.getString(1);   		 
		    	  }
		    	 
		    	out.println("<p>Order id:"+arr[i]+"<p>");
				out.println("<p>Order date:"+date+"<p>");
				out.println("<p>Order price:"+price+"<p>");
				out.println("<br/>");
				
				String sql4="select * from Orders_Product where orders_id="+arr[i];
				String sqlN2="SELECT COUNT(*) FROM Orders_Product where orders_id="+arr[i];
				
				ps=ct.prepareStatement(sqlN2);
		    	  rs=ps.executeQuery();    	 
		    	  if(rs.next()){    		  
		    		  m=rs.getInt(1);   		 
		    	  }
		    	  
			
		    	  ps=ct.prepareStatement(sql4);
		    	  rs=ps.executeQuery();   
		    	  String[] arr2=new String[m];
		    	  List list2 = new ArrayList();   	  
		    	  while(rs.next()){
		    		  list2.add(rs.getString("product_id"));	    			
		    	    }
		    	  
		    	  
		    	  for (int j = 0;j<list2.size();j++) {
		    		arr2[j]= list2.get(j).toString();
		    		
		    		
		    		
		    		String sql5="select name from Product where id="+arr2[j];
		    		 ps=ct.prepareStatement(sql5);
			    	 rs=ps.executeQuery();
			    	 if(rs.next()){    		  
			    		 name=rs.getString(1);   		 
			    	  }
		    		
			    	 String sql6="select unit_price from Product where id="+arr[j];
		    		 ps=ct.prepareStatement(sql6);
			    	 rs=ps.executeQuery();
			    	 if(rs.next()){    		  
			    		 unit_price=rs.getString(1);   		 
			    	  }
			    	 
			    	 String sql7="select product_description from Product where id="+arr2[j];
		    		 ps=ct.prepareStatement(sql7);
			    	 rs=ps.executeQuery();
			    	 if(rs.next()){    		  
			    		 description=rs.getString(1);   		 
			    	  }
			    	 
			    	 String sql8="select purchase_number from Orders_Product where product_id="+arr2[j]+" and orders_id="+arr[i];
		    		 ps=ct.prepareStatement(sql8);
			    	 rs=ps.executeQuery();
			    	 if(rs.next()){    		  
			    		 purchase_number=rs.getString(1);   		 
			    	  }
			    	 
			    	 
			    	 
			    	 out.println("<p>product id:"+arr2[j]+"<p>");
			    	 out.println("<p>product name:"+name+"<p>");
			    	 out.println("<p>product unit price:"+unit_price+"<p>");
			    	 out.println("<p>product description:"+description+"<p>");
			    	 out.println("<p>purchase number:"+purchase_number+"<p>");
			    	 out.println("<br/>");
			    	 
		    	  }
		    	
		    	 
				out.println("<hr/>");
	    	  }
	    		 
		
	    		  
	    		  
	    		  
				
				
				/*String sql2="select * from Orders where id="+arr[i];
				stmt=conn.createStatement();
				resultSet=stmt.executeQuery(sql2);
				out.println("<p>Order id:"+resultSet.getString(1)+"<p>");
				out.println("<p>Order date:"+resultSet.getString(2)+"<p>");
				out.println("<p>Order price:"+resultSet.getString(3)+"<p>");
				
				String sql3="select product_id from Orders_Product where orders_id="+arr[i];
				String sqlN2="SELECT COUNT(*) FROM Orders_Product where orders_id="+arr[i];
				
				stmt=conn.createStatement();
				resultSet=stmt.executeQuery(sqlN2);
				if(resultSet.next()){
					m=resultSet.getInt(1);
				}
				
				int [] arr2=new int [m];
				stmt=conn.createStatement();
				resultSet=stmt.executeQuery(sql3);
				
					for(int j=0;j<m;j++){
						arr2[j]=resultSet.getInt(j+1);
						String sql4="select purchase_number from Orders_Product where product_id="+arr2[j]+" and orders_id="+arr[i];
						stmt=conn.createStatement();
						resultSet=stmt.executeQuery(sql4);
						out.println("<p>Product id:"+arr2[j]+"<p>");
						out.println("<p>Product Number:"+resultSet.getString(1)+"<p>");
						
						String sql5="select * from Product where id="+arr2[j];
						stmt=conn.createStatement();
						resultSet=stmt.executeQuery(sql5);
				
						out.println("<p>Product Name:"+resultSet.getString(2)+"<p>");
						out.println("<p>Product unit price:"+resultSet.getString(3)+"<p>");
						out.println("<p>Product description:"+resultSet.getString(5)+"<p>");
											
					
				}
				*/
				
				
				
				
				
				

			
		
		
		out.println("</body>");
		out.println("</html>");


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
  	  
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
