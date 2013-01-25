<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show My Cart</title>
</head>
<body>

 <center><img src="images/cart.jpg"/><a href="/DBproject/hall.jsp">Continue shopping</a></center>
	<form action="/DBproject/ShoppingCl?type=update" method="post">
	<center>
	<div class="cart">
		<table border="1" style="border-collapse:collapse;width:600px">
			<tr><td>ID</td><td>Name</td><td>Product image</td><td>Unit price</td><td>Description</td><td>number</td><td>delete</td></tr>
			
		   <%
		       // 从request 取出商品信息
		       ArrayList al=(ArrayList)request.getAttribute("productList");
		       for(int i=0;i<al.size();i++){
		    	   Product product=(Product)al.get(i);
		    	  %>
		      <tr><td><%=product.getId()%><input type='hidden' name="id" value="<%=product.getId()%>"></td>	  
		      <td><%=product.getName()%></td>
			  <td><img src="images/<%=product.getId()%>.jpg" width="250" height="235"/></td>			  
			  <td><%=product.getUnit_price() %></td>
			  <td><%=product.getProduct_description() %></td>		    	  		    	  		    	  		    
		      <td><input type='text' name='productnum' value='<%=product.getShoppingNum() %>'/>Numbers</td>
		      <td><a href="/DBproject/ShoppingCl?type=del&id=<%=product.getId()%>">Delete</a></td></tr>
		    	  <% 
		       }
		   %>	    
		    <tr><td colspan="7"><input type="submit" value="update"></td></tr>
		    <tr><td colspan="7">MyCart Total Price:${totalPrice} euro</td></tr>		
		</table>
		</div>
		</center>
	</form><br/><br/>
	<center>
	 <a href="/DBproject/GoMyOrder">Submit Order</a>
	 </center>

</body>
</html>