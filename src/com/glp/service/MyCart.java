package com.glp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import com.glp.domain.Product;

//这个表示我的购物车
public class MyCart {
      
	HashMap<String,Product> hm=new HashMap<String,Product>();
	
	public void addProduct2(String id){
		if(hm.containsKey(id)){
			//如果买过，shoppingNum就加1
			Product product=hm.get(id);
			int shoppingNum=product.getShoppingNum();
			product.setShoppingNum(shoppingNum+1);
		}else{		
		hm.put(id, new SupplierService().getProductById(id));
		}
	}
	
	
	//添加书
	public void addProduct(String id,Product product){
		if(hm.containsKey(id)){
			//如果买过，shoppingNum就加1
			product=hm.get(id);
			int shoppingNum=product.getShoppingNum();
			product.setShoppingNum(shoppingNum+1);
			//hm.put(id, book);
		}else{		
		hm.put(id, product);
		}
	}
	
	//删除书
	public void delProduct(String id){
		hm.remove(id);
	}
		
	//更新书(购物车的更新   更新的是数量)
	public void updateProduct(String id,String nums){
		
		Product product=hm.get(id);
		product.setShoppingNum(Integer.parseInt(nums));
		
	}
	
	//显示购物车中所有商品
	public ArrayList showMyCart(){
		ArrayList<Product> al=new ArrayList<Product>();
		//遍历HashMap
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			//取key
			String id=(String) iterator.next();
			//取book
			Product product=hm.get(id);
			al.add(product);
		}
		return al;
	}
	
	//得到总价
	public float getTotalPrice(){
		
		float totalPrice=0.0f;
		ArrayList<Product> al=new ArrayList<Product>();
		//遍历HashMap
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			//取key
			String productId=(String) iterator.next();
			//取book
			Product product=hm.get(productId);
			totalPrice=totalPrice+Integer.parseInt(product.getUnit_price())*product.getShoppingNum();
		}
		return totalPrice;
	}
	
	//清空书  清空购物车
	public void clearProduct(){
		hm.clear();
		
	}
}
