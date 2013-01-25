package shoppingServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glp.domain.Product;
import com.glp.service.MyCart;
import com.glp.util.SqlHelper;

/**
 * Servlet implementation class confirmOrder
 */
@WebServlet("/confirmOrder")
public class confirmOrder extends HttpServlet {
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out=response.getWriter();
		
		MyCart myCart=(MyCart) request.getSession().getAttribute("myCart");
		ArrayList al=myCart.showMyCart();
		float totalPrice=myCart.getTotalPrice();		
		request.setAttribute("orderinfo", al);
		request.setAttribute("totalPrice", totalPrice);
		
		 HttpSession session=request.getSession();
			
		 String Cid=session.getAttribute("Cid")+"";	
		
		int ONum,PNum,OPNum,SNum;
		ONum=PNum=OPNum=SNum=0;
		int id,shipment_id,PurchaseHistory_id,OrdersProduct_id;
		id=shipment_id=PurchaseHistory_id=OrdersProduct_id=1;
	
		
		String sqlO="select * from Orders order by id";
	    String sqlONum="SELECT COUNT(*) FROM Orders";    
		String sql="insert into Orders values(?,?,?,?,?)";
		
		String sqlP="select * from PurchaseHistory order by id";
	    String sqlPNum="SELECT COUNT(*) FROM PurchaseHistory";    
		String sql1="insert into PurchaseHistory values(?,?,?)";
		
		String sqlOP="select * from Orders_Product order by id";
	    String sqlOPNum="SELECT COUNT(*) FROM Orders_Product";    
		String sql2="insert into Orders_Product values(?,?,?,?)";
				
		String sqlS="select * from Shipment order by id";
	    String sqlSNum="SELECT COUNT(*) FROM Shipment";  
	    String sql3="insert into Shipment values(?,?,?,?,?)";

  	 
  			
  	 try{
			 
	    	 ct=SqlHelper.getConnection();	    	  
	    	  ct.setAutoCommit(false);
	    	  
	    	  id=SqlHelper.returnId(sqlONum, ONum, sqlO, id);
	    	  shipment_id=SqlHelper.returnId(sqlSNum, SNum, sqlS, shipment_id);
	    	  PurchaseHistory_id=SqlHelper.returnId(sqlPNum, PNum, sqlP, PurchaseHistory_id);
	    	  OrdersProduct_id=SqlHelper.returnId(sqlOPNum, OPNum, sqlOP, OrdersProduct_id);	    	 
	    	  
	    	  ps=ct.prepareStatement(sql);
	    	  ps.setInt(1, id);
	    	  ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
	    	  ps.setString(3, totalPrice+"");
	    	  ps.setInt(4, shipment_id);
	    	  ps.setInt(5, PurchaseHistory_id);
	    	  ps.executeUpdate();
	    	  
	    	  ps=ct.prepareStatement(sql1);
	    	  ps.setInt(1, PurchaseHistory_id);
	    	  ps.setInt(2, Integer.parseInt(Cid));
	    	  ps.setInt(3, id);    	  
	    	  ps.executeUpdate();
	    	
	    	  ps=ct.prepareStatement(sql3);
   	    	  ps.setInt(1, shipment_id);
   	    	  ps.setInt(2, id);
   	    	  ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
   	    	  ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
   	    	  ps.setString(5, totalPrice*0.2+"");    	  
   	    	  ps.executeUpdate();
   	    	  
	    	  for(int j=0;j<al.size();j++){
	    			Product product=(Product)al.get(j);
	    			
	    		  ps=ct.prepareStatement(sql2);
	   	    	  ps.setInt(1, OrdersProduct_id);
	   	    	  ps.setInt(2, product.getId());
	   	    	  ps.setInt(3, id); 
	   	    	  ps.setInt(4, product.getShoppingNum());    	  
	   	    	  ps.executeUpdate();   	    	 
	   	    			
	          String sql4="UPDATE Product SET number=number-"+product.getShoppingNum()+" WHERE id ='"+product.getId()+"'";
	            ps=ct.prepareStatement(sql4);		    	    	  
 	               ps.executeUpdate();  
	    	  
	    	  
	    	  }
	    	  	    	      	  
	    	 
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
  	 
  	 
  	      myCart.clearProduct();
  	      request.getRequestDispatcher("/OrderOk.html").forward(request, response);
  	 
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
