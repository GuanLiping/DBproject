<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>
</head>
<body>
<h1>Welcome, product information!</h1>
	
		<table border="1">
			<tr><td>ID</td><td>Product image</td><td>Name</td><td>Unit price</td><td>Number</td><td>Description</td></tr>
			<%
			HttpSession sessionS=request.getSession();
			SupplierService supplierService=new SupplierService();
			String Sid=(String) sessionS.getAttribute("Sid");
			ArrayList al=supplierService.getAllProduct(Sid);
			    
			     for(int i=0;i<al.size();i++){
			    	 Product product=(Product) al.get(i);
			    	 %>
			  <tr><td><%=product.getId() %></td>
			  <td><img src="images/<%=product.getId()%>.jpg" width="150" height="150"/></td>
			  <td><%=product.getName()  %></td>
			  <td><%=product.getUnit_price() %></td>
			  <td><%=product.getNumber() %></td>
			  <td><%=product.getProduct_description() %></td>			   
			   </tr>		  			 
			    	 <% 
			     }		
			%>
			
		   	
		</table><br/><br/>
		<center>
		<a href="/DBproject/SupplierMain">Back to Supplier Main Page</a>
		</center>
</body>
</html>