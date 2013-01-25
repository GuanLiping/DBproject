<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*,javax.servlet.http.HttpSession" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Supplier</title>
</head>
<body>


<table border="1">
			<tr><td>ID</td><td>Name</td><td>Password</td><td>Phone Number</td><td>Email</td><td>Street</td><td>Zip code</td><td>City</td><td>Country</td></tr>
			<%
			HttpSession sessionS=request.getSession();
			SupplierService supplierService=new SupplierService();
			ManagerService managerService=new ManagerService();
			
			ArrayList al=managerService.getAllSupplier();
			    
			     for(int i=0;i<al.size();i++){
			    	 Supplier supplier=(Supplier) al.get(i);
			    	 Address address=supplierService.getAdressById(supplier.getAddress_id()+"");
			    	 %>
			  <tr><td><%=supplier.getId() %></td>
			  <td><%=supplier.getName()  %></td>
			  <td><%=supplier.getPassword() %></td>
			  <td><%=supplier.getPhone_number() %></td>
			  <td><%=supplier.getEmail() %></td>
			  <td><%=address.getStreet() %></td>
			  <td><%=address.getZip_code() %></td>
			  <td><%=address.getCity() %></td>
			  <td><%=address.getCountry() %></td>			   
			   </tr>		  			 
			    	 <% 
			     }		
			%>
			
		   	
		</table><br/><br/>
		<center>
		<a href="/DBproject/ManagerSupplier">Back to ManagerSupplier Page</a>
		</center>

</body>
</html>