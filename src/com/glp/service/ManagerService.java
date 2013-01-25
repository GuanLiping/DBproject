package com.glp.service;

import java.sql.*;
import java.util.ArrayList;


import com.glp.domain.Address;
import com.glp.domain.Customer;
import com.glp.domain.Manager;
import com.glp.domain.Product;
import com.glp.domain.Supplier;
import com.glp.util.SqlHelper;



public class ManagerService {
	
		
	public boolean delCustomer(String id){
		boolean b=true;
		String sql="delete from Customer where id=?";
		String parameters[]={id};
		try{
	    SqlHelper.executeUpdate(sql, parameters);
		}catch(Exception e){
			b=false;
		}
		return b;
	}
	
	public boolean delSupplier(String id){
		boolean b=true;
		String sql="delete from Supplier where id=?";
		String parameters[]={id};
		try{
	    SqlHelper.executeUpdate(sql, parameters);
		}catch(Exception e){
			b=false;
		}
		return b;
	}
	
	
	
       //验证用户是否合法的函数
	public boolean checkCustomer(Customer customer){
		
		boolean b=false;
		String sql="select * from Customer where id=? and password=?";
		String parameters[]={customer.getId()+" ",customer.getpassword()};
		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
		
		try {
			if(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return b;
	}
	

	
     public boolean checkSupplier(Supplier supplier){
		
		boolean b=false;
		String sql="select * from Supplier where id=? and password=?";
		String parameters[]={supplier.getId()+" ",supplier.getPassword()};
		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
		
		try {
			if(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return b;
	}

     
     public boolean checkManager(Manager manager){
 		
 		boolean b=false;
 		String sql="select * from Manager where id=? and password=?";
 		String parameters[]={manager.getId()+" ",manager.getPassword()};
 		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
 		
 		try {
 			if(rs.next()){
 				b=true;
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}finally{
 			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
 		}
 		return b;
 	}
     
     public ArrayList getAllProduct(){
 		
 		String sql="select * from Product where 1=?";
 		String paras[]={"1"};
 		ArrayList al=new SqlHelper().executeQuery3(sql, paras);
 		ArrayList<Product> newAl=new ArrayList<Product>();
 		
 		//二次业务封装
 		for(int i=0;i<al.size();i++){
 			Object obj[]=(Object[]) al.get(i);
 			Product product=new Product();
 			product.setId(Integer.parseInt(obj[0].toString()));
 			product.setName(obj[1].toString());
 			product.setUnit_price(obj[2].toString());
 			product.setNumber(obj[3].toString());     
 			product.setProduct_description(obj[4].toString());
 						
 			newAl.add(product);
 		}
 		return newAl;
 	}
     
     public ArrayList getAllCustomer(){
  		
  		String sql="select * from Customer where 1=?";
  		String paras[]={"1"};
  		ArrayList al=new SqlHelper().executeQuery3(sql, paras);
  		ArrayList<Customer> newAl=new ArrayList<Customer>();
  		
  		//二次业务封装
  		for(int i=0;i<al.size();i++){
  			Object obj[]=(Object[]) al.get(i);
  			Customer customer=new Customer();
  			customer.setId(Integer.parseInt(obj[0].toString()));
  			customer.setName(obj[1].toString());
  			customer.setpassword(obj[2].toString());
  			customer.setCategory(obj[3].toString());
  			customer.setPhone_number(obj[4].toString());
  			customer.setEmail(obj[5].toString());
  			customer.setAddress_id(Integer.parseInt(obj[6].toString()));
   						
  			newAl.add(customer);
  		}
  		return newAl;
  	}
     
     public ArrayList getAllSupplier(){
   		
   		String sql="select * from Supplier where 1=?";
   		String paras[]={"1"};
   		ArrayList al=new SqlHelper().executeQuery3(sql, paras);
   		ArrayList<Supplier> newAl=new ArrayList<Supplier>();
   		
   		//二次业务封装
   		for(int i=0;i<al.size();i++){
   			Object obj[]=(Object[]) al.get(i);
   			Supplier supplier=new Supplier();
   			supplier.setId(Integer.parseInt(obj[0].toString()));
			supplier.setName(obj[1].toString());
			supplier.setPassword(obj[2].toString());
			supplier.setPhone_number(obj[3].toString());
			supplier.setEmail(obj[4].toString());
			supplier.setAddress_id(Integer.parseInt(obj[5].toString()));
   						
   			newAl.add(supplier);
   		}
   		return newAl;
   	}
}
