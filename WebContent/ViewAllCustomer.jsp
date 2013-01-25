<%@ page language="java" import="java.util.*,com.glp.domain.*,com.glp.service.*,javax.servlet.http.HttpSession" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Customer</title>
</head>
<body>

<table border="1">
			<tr><td>ID</td><td>Name</td><td>Password</td><td>Category</td><td>Phone Number</td><td>Email</td><td>Street</td><td>Zip code</td><td>City</td><td>Country</td></tr>
			<%
			HttpSession sessionS=request.getSession();
			CustomerService customerService=new CustomerService();
			ManagerService managerService=new ManagerService();
			
			ArrayList al=managerService.getAllCustomer();
			    
			     for(int i=0;i<al.size();i++){
			    	 Customer customer=(Customer) al.get(i);
			    	 Address address=customerService.getAdressById(customer.getAddress_id()+"");
			    	 %>
			  <tr><td><%=customer.getId() %></td>
			  <td><%=customer.getName()  %></td>
			  <td><%=customer.getpassword() %></td>
			   <td><%=customer.getCategory() %></td>
			  <td><%=customer.getPhone_number() %></td>
			  <td><%=customer.getEmail() %></td>
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
		<a href="/DBproject/ManagerCustomer">Back to ManagerCustomer Page</a>
		</center>

</body>
</html>