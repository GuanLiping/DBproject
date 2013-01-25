<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify my information</title>
</head>
<body>
<form action="/DBproject/ModifySupplier" method="post">
<table border="1">
			
			<%
			HttpSession sessionS=request.getSession();
			Supplier supplier=(Supplier) sessionS.getAttribute("supplier");
			Address address=(Address) sessionS.getAttribute("SAddress");		
			    	 %>
			    	 
			  <tr><td>ID</td><td><%=supplier.getId()%><input type="hidden" name='id' value="<%=supplier.getId()%>"></td></tr>
			  <tr><td>Name</td><td><input type="text" name='name' value="<%=supplier.getName() %>"/></td>
			  <tr><td>Password</td><td><input type="text" name='password' value="<%=supplier.getPassword() %>"/></td></tr>
			  <tr><td>Phone number</td><td><input type="text" name='phone_number' value="<%=supplier.getPhone_number() %>"/></td></tr>
			  <tr><td>Email</td><td><input type="text" name='email' value="<%=supplier.getEmail() %>"/></td></tr>
			  <tr><td>Street</td><td><input type="text" name='street' value="<%=address.getStreet() %>"/></td></tr>
			  <tr><td>Zip code</td><td><input type="text" name='zip_code' value="<%=address.getZip_code() %>"/></td></tr>
			  <tr><td>City</td><td><input type="text" name='city' value="<%=address.getCity() %>"/></td></tr>
			  <tr><td>Country</td><td><input type="text" name='country' value="<%=address.getCountry() %>"/></td></tr>
			  	  			 		
		   	
		</table><br/><br/>
		<center>
		<input type="submit" value="Update"/>
		</center>
	</form>

</body>
</html>