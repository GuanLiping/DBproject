package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Address;
import com.glp.domain.Customer;
import com.glp.service.ManagerService;
import com.glp.util.SqlHelper;



public class customerRegister extends HttpServlet {
	
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
				
		  int id=0;
		  int cNum=0;
	      String name=request.getParameter("name");
	      String password=request.getParameter("password");
	      String category=request.getParameter("category");    
	      String phone_number=request.getParameter("phone_number"); 
	      String email=request.getParameter("email");
	      
		  int address_id=0;
		  int aNum=0;
		  String street=request.getParameter("street");
		  String zip_code=request.getParameter("zip_code");
		  String city=request.getParameter("city");
		  String country=request.getParameter("country");
		  
		  
		  /*request.setAttribute("streetC", street);
		  request.setAttribute("zip_codeC", zip_code);
		  request.setAttribute("cityC", city);
		  request.setAttribute("countryC", country);*/
		  
		  String sqlc="select * from Customer order by id";
		  String sqla="select * from Address";
		  String sqlcNum="SELECT COUNT(*) FROM Customer";
		  String sqlaNum="SELECT COUNT(*) FROM Address";
		  
		  String sql1="insert into Customer values(?,?,?,?,?,?,?)";
		  String sql2="insert into Address values(?,?,?,?,?)";
		   
	      
	    	  try{
	    	  ct=SqlHelper.getConnection();	    	  
	    	  ct.setAutoCommit(false);
	       	 
	    	  ps=ct.prepareStatement(sqlcNum);
	    	  rs=ps.executeQuery();    	 
	    	  if(rs.next()){    		  
	    		  cNum=rs.getInt(1);
	    		 
	    	  }
	    	  
	    	  ps=ct.prepareStatement(sqlaNum);
	    	  rs=ps.executeQuery();    	 
	    	  if(rs.next()){    		  
	    		  aNum=rs.getInt(1);
	    		 
	    	  }
	    	  
	    	  
	    	  ps=ct.prepareStatement(sqlc);
	    	  rs=ps.executeQuery();  		   
	    	  id=1;
	    	  String[] arr=new String[cNum];
	    	  List list1 = new ArrayList();   	  
	    	  while(rs.next()){
	    		  list1.add(rs.getString("id"));	    			
	    	    }
	    	  
	    	  for (int i = 0;i<list1.size();i++) {
	    		arr[i]= list1.get(i).toString();
	    		//  System.out.println(arr[i]);
	    	  }
	    		  for(int i=0;i<cNum;i++)
	    		  {	    			  	    			
	    			 if(id<Integer.parseInt(arr[i])){
	    				  break;
	    			  }else if(id==Integer.parseInt(arr[i])){
	    				  id=id+1;
	    			  }  		  
	    	  }
	    	  
	    		  
	    	  ps=ct.prepareStatement(sqla);
	    	  rs=ps.executeQuery();    	  
	  		  address_id=1;
	  		  String[] arr2=new String[aNum];
	    	  List list2 = new ArrayList();  
	    	  while(rs.next()){
	    		  list2.add(rs.getString("id"));
	    		  
	    	    }
	    	  
	    	  for (int i= 0;i<list2.size();i++) {
		    		arr2[i]= list2.get(i).toString();
		    		 //System.out.println(arr2[i]);
		    	  }
	    		  for(int i=0;i<aNum;i++)
	    		  {    			  	    			
	    			 if(address_id<Integer.parseInt(arr2[i])){
	    				  break;
	    			  }else if(address_id==Integer.parseInt(arr2[i])){
	    				  address_id=address_id+1;
	    			  }
	    		  
	    	  }
	    	 
	    		  //System.out.println(address_id);
	       	  //request.setAttribute("address_idC", address_id);
	    	  ps=ct.prepareStatement(sql1);
	    	  ps.setInt(1, id);
	    	  ps.setString(2, name);
	    	  ps.setString(3, password);
	    	  ps.setString(4, category);
	    	  ps.setString(5, phone_number);
	    	  ps.setString(6, email);
	    	  ps.setInt(7, address_id);
	    	  ps.executeUpdate();
	    	  
	    	  ps=ct.prepareStatement(sql2);
	    	  ps.setInt(1, address_id);
	    	  ps.setString(2, street);
	    	  ps.setString(3, zip_code);
	    	  ps.setString(4, city);
	    	  ps.setString(5, country);
	    	  ps.executeUpdate();
	    	  
	    	  
	          
	    	  Address address=new Address();
			  address.setAddress_id(address_id);
			  address.setStreet(street);
			  address.setZip_code(zip_code);
			  address.setCity(city);
			  address.setCountry(country);
			  request.setAttribute("customerAddress", address);
			  
			  Customer customer=new Customer();
			  customer.setId(id);
			  customer.setName(name);
			  customer.setpassword(password);
			  customer.setCategory(category);
			  customer.setPhone_number(phone_number);
			  customer.setEmail(email);			  
			  //request.setAttribute("customer", customer);
			  
			  HttpSession session=request.getSession();
			  session.setAttribute("Cid", id);
			  
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
	    	  
	    	 
	    	  
	    	  request.getRequestDispatcher("/CustomerMain").forward(request, response); 
	    	
	      	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
