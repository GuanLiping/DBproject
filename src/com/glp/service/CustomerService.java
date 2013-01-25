package com.glp.service;

import java.util.ArrayList;

import com.glp.domain.Address;
import com.glp.domain.Customer;
import com.glp.util.SqlHelper;

public class CustomerService {
	
	public Customer getCustomerById(String id){
		Customer customer=new Customer();
		String sql="select * from Customer where id=?";
		String paras[]={id};
		ArrayList al=new SqlHelper().executeQuery3(sql, paras);
		if(al.size()==1){
			Object [] obj=(Object[]) al.get(0);
			
			customer.setId(Integer.parseInt(obj[0].toString()));
			customer.setName(obj[1].toString());
			customer.setpassword(obj[2].toString());
			customer.setCategory(obj[3].toString());
			customer.setPhone_number(obj[4].toString());
			customer.setEmail(obj[5].toString());
			customer.setAddress_id(Integer.parseInt(obj[6].toString()));
		}
		return customer;
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
	
	
	
	
}
