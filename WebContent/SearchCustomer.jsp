<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*,javax.servlet.http.HttpSession" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Customer By ID</title>
</head>
<body>

<table border="1">
			
			<%
			HttpSession sessionS=request.getSession();
			Customer customer=(Customer) sessionS.getAttribute("customer");
			CustomerService customerService=new CustomerService();
			Address address=customerService.getAdressById(customer.getAddress_id()+"");		
			    	 %>
			    	 
			  <tr><td>ID</td><td><%=customer.getId() %></td></tr>
			  <tr><td>Name</td><td><%=customer.getName()%></td>
			  <tr><td>Password</td><td><%=customer.getpassword() %></td></tr>
			  <tr><td>Category</td><td><%=customer.getCategory() %></td></tr>
			  <tr><td>Phone number</td><td><%=customer.getPhone_number() %></td></tr>
			  <tr><td>Email</td><td><%=customer.getEmail() %></td></tr>
			  <tr><td>Street</td><td><%=address.getStreet() %></td></tr>
			  <tr><td>Zip code</td><td><%=address.getZip_code() %></td></tr>
			  <tr><td>City</td><td><%=address.getCity() %></td></tr>
			  <tr><td>Country</td><td><%=address.getCountry() %></td></tr>
			  	  			 		
		   	
		</table><br/><br/>
		<center>
		<a href="/DBproject/ManagerSupplier">Back to Supplier Main Page</a>
		</center>
</body>
</html>