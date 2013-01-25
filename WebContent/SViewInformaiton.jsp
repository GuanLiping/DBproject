<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*,javax.servlet.http.HttpSession" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Supplier Information</title>
</head>
<body>
<h1>Welcome, supplier information!</h1>
	
		<table border="1">
			
			<%
			HttpSession sessionS=request.getSession();
			Supplier supplier=(Supplier) sessionS.getAttribute("supplier");
			Address address=(Address) sessionS.getAttribute("SAddress");		
			    	 %>
			    	 
			  <tr><td>ID</td><td><%=supplier.getId()%></td></tr>
			  <tr><td>Name</td><td><%=supplier.getName()%></td>
			  <tr><td>Password</td><td><%=supplier.getPassword() %></td></tr>
			  <tr><td>Phone number</td><td><%=supplier.getPhone_number() %></td></tr>
			  <tr><td>Email</td><td><%=supplier.getEmail() %></td></tr>
			  <tr><td>Street</td><td><%=address.getStreet() %></td></tr>
			  <tr><td>Zip code</td><td><%=address.getZip_code() %></td></tr>
			  <tr><td>City</td><td><%=address.getCity() %></td></tr>
			  <tr><td>Country</td><td><%=address.getCountry() %></td></tr>
			  	  			 		
		   	
		</table><br/><br/>
		<center>
		<a href="/DBproject/SupplierMain">Back to Supplier Main Page</a>
		</center>
	
</body>
</html>