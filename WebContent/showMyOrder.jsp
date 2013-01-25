<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show My Order</title>
</head>
<body>
<script type="text/javascript">
    <!--
            function goSubmitOrder(){
    	    window.location.href="/DBproject/confirmOrder";
         }
    //-->
   </script>
</head>
<body>
<div class="order">
<center><h1>My Order</h1></center>
<h2>My information</h2>

<table style="border-collapse: collapse" border="1">
<tr><td colspan="2">Customer Personal information</td></tr>
<tr><td>User name</td><td><%=((Customer)session.getAttribute("customer")).getName() %></td></tr>
<tr><td>Category</td><td><%=((Customer)session.getAttribute("customer")).getCategory() %></td></tr>
<tr><td>Phone number</td><td><%=((Customer)session.getAttribute("customer")).getPhone_number() %></td></tr>
<tr><td>Email</td><td><%=((Customer)session.getAttribute("customer")).getEmail() %></td></tr>

</table>
<hr/>
<h2>My purchase</h2>
<table style="border-collapse: collapse" border="1">
<tr><td>ID</td><td>Product image</td><td>Name</td><td>Unit price</td><td>Description</td><td>Purchase Number</td></tr>
<%
      ArrayList al=(ArrayList)request.getAttribute("orderinfo");
      for(int i=0;i<al.size();i++){
    	  Product product=(Product)al.get(i);
    	  %>
    	  <tr><td><%=product.getId()%><input type='hidden' name="id" value="<%=product.getId()%>"></td>
    	  <td><img src="images/<%=product.getId()%>.jpg" width="150" height="150"/></td>
		  <td><%=product.getName()  %></td>
		  <td><%=product.getUnit_price() %></td>
		  <td><%=product.getProduct_description() %></td>
    	  <td><%=product.getShoppingNum() %></td>
    	  <% 
      }
%>
<tr><td colspan="6">Total price of your cart:${totalPrice} euro</td></tr>
</table><br/>
<center>
<input type="button" onclick="goSubmitOrder()" value="Confirm"/></center>
</div>
</body>
</html>