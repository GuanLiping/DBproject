<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Product numbers</title>
</head>
<body>

<h1>Welcome, Modify Product numbers</h1>
	<form action="/DBproject/ModifyProduct" method="post">
		<table border="1">
			<tr><td>ID</td><td>Product image</td><td>Name</td><td>Unit price</td><td>Number</td><td>Description</td></tr>
			<%
			ManagerService managerService=new ManagerService();	
			
			ArrayList al=managerService.getAllProduct();
			    
			     for(int i=0;i<al.size();i++){
			    	 Product product=(Product) al.get(i);
			    	 %>
			  <tr><td><%=product.getId()%><input type="hidden" name="id" value="<%=product.getId()%>"></td>
			  <td><img src="images/<%=product.getId()%>.jpg" width="150" height="150"/></td>
			  <td><%=product.getName()%></td>
			  <td><%=product.getUnit_price() %></td>
			  <td><input type="text" name='productNum' value="<%=product.getNumber() %>"/></td>
			  <td><%=product.getProduct_description() %></td>			   
			   </tr>		  			 
			    	 <% 
			     }		
			%>
			
		   	
		</table><br/><br/>
		<center>
		<input type="submit" value="Update"/>
		</center>
</form>
</body>
</html>