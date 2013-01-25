package com.glp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.glp.domain.Address;
import com.glp.domain.Product;
import com.glp.domain.Supplier;
import com.glp.util.SqlHelper;


public class SupplierService {
		
	public Supplier getSupplierById(String id){
		Supplier supplier=new Supplier();
		String sql="select * from Supplier where id=?";
		String paras[]={id};
		ArrayList al=new SqlHelper().executeQuery3(sql, paras);
		if(al.size()==1){
			Object [] obj=(Object[]) al.get(0);
			
			supplier.setId(Integer.parseInt(obj[0].toString()));
			supplier.setName(obj[1].toString());
			supplier.setPassword(obj[2].toString());
			supplier.setPhone_number(obj[3].toString());
			supplier.setEmail(obj[4].toString());
			supplier.setAddress_id(Integer.parseInt(obj[5].toString()));
		}
		return supplier;
	}
	
	public Address getAdressById(String address_id){
		Address address=new Address();
		String sql="select * from Address where id=?";
		String paras[]={address_id};
		ArrayList al=new SqlHelper().executeQuery3(sql, paras);
		if(al.size()==1){
			Object [] obj=(Object[]) al.get(0);
			
			address.setAddress_id(Integer.parseInt(obj[0].toString()));
			address.setStreet(obj[1].toString());
			address.setZip_code(obj[2].toString());
			address.setCity(obj[3].toString());
			address.setCountry(obj[4].toString());
			
		}
		return address;
	}
	
	public Product getProductById(String id){
		String sql="select * from Product where id=?";
		String paras[]={id};
		Product product=new Product();
		ArrayList al=new SqlHelper().executeQuery3(sql, paras);
		if(al.size()==1){
			Object [] obj=(Object[]) al.get(0);
						
			product.setId(Integer.parseInt(obj[0].toString()));
			product.setName(obj[1].toString());
			product.setUnit_price(obj[2].toString());
			product.setNumber(obj[3].toString());     
			product.setProduct_description(obj[4].toString());
			
		}
		return product;
	}
	

public ArrayList getAllProduct(String supplier_id){
		
		String sql="select * from Product where supplier_id=?";
		String paras[]={supplier_id};
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
}
