package com.glp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import com.glp.domain.Product;

//�����ʾ�ҵĹ��ﳵ
public class MyCart {
      
	HashMap<String,Product> hm=new HashMap<String,Product>();
	
	public void addProduct2(String id){
		if(hm.containsKey(id)){
			//��������shoppingNum�ͼ�1
			Product product=hm.get(id);
			int shoppingNum=product.getShoppingNum();
			product.setShoppingNum(shoppingNum+1);
		}else{		
		hm.put(id, new SupplierService().getProductById(id));
		}
	}
	
	
	//�����
	public void addProduct(String id,Product product){
		if(hm.containsKey(id)){
			//��������shoppingNum�ͼ�1
			product=hm.get(id);
			int shoppingNum=product.getShoppingNum();
			product.setShoppingNum(shoppingNum+1);
			//hm.put(id, book);
		}else{		
		hm.put(id, product);
		}
	}
	
	//ɾ����
	public void delProduct(String id){
		hm.remove(id);
	}
		
	//������(���ﳵ�ĸ���   ���µ�������)
	public void updateProduct(String id,String nums){
		
		Product product=hm.get(id);
		product.setShoppingNum(Integer.parseInt(nums));
		
	}
	
	//��ʾ���ﳵ��������Ʒ
	public ArrayList showMyCart(){
		ArrayList<Product> al=new ArrayList<Product>();
		//����HashMap
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			//ȡkey
			String id=(String) iterator.next();
			//ȡbook
			Product product=hm.get(id);
			al.add(product);
		}
		return al;
	}
	
	//�õ��ܼ�
	public float getTotalPrice(){
		
		float totalPrice=0.0f;
		ArrayList<Product> al=new ArrayList<Product>();
		//����HashMap
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			//ȡkey
			String productId=(String) iterator.next();
			//ȡbook
			Product product=hm.get(productId);
			totalPrice=totalPrice+Integer.parseInt(product.getUnit_price())*product.getShoppingNum();
		}
		return totalPrice;
	}
	
	//�����  ��չ��ﳵ
	public void clearProduct(){
		hm.clear();
		
	}
}
