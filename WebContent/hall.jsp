<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/index.css" type="text/css" rel="stylesheet"/>
<title>Shopping Hall</title>
</head>
<body>
<img src="images/hall.jpg"/><a href="/DBproject">Logout</a>
<div class="hall">
 <center>
		<table border="1">
			<tr><td>Name</td><td>Product image</td><td>Unit price</td><td>Description</td><td>Buy</td></tr>
			<%
            ManagerService managerService=new ManagerService();				
			ArrayList al=managerService.getAllProduct();
			     for(int i=0;i<al.size();i++){
			    	 Product product=(Product) al.get(i);
			    	 %>
			  <tr>
			  <td><%=product.getName()%></td>
			  <td><img src="images/<%=product.getId()%>.jpg" width="250" height="235"/></td>			  
			  <td><%=product.getUnit_price() %></td>
			  <td><%=product.getProduct_description() %></td>	 	 			  
			  <td><a href="/DBproject/ShoppingCl?type=add&id=<%=product.getId()%>">Add to Cart</a></td></tr>
			  
		 
			    	 <% 
			     }		
			%>
			
		    	
		</table>
		</center><br/>
		
</div>
</body>
</html>