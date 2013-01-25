package com.glp.domain;

public class Product {
   private int id;
   private String name;
   private String unit_price;
   private String number;
   private String product_description;
   private int supplier_id;
   private int shoppingNum=1;     //¹ºÂòµÄÊýÁ¿
	public int getShoppingNum() {
		return shoppingNum;
	}
	public void setShoppingNum(int shoppingNum) {
		this.shoppingNum = shoppingNum;
	}
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUnit_price() {
	return unit_price;
}
public void setUnit_price(String unit_price) {
	this.unit_price = unit_price;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getProduct_description() {
	return product_description;
}
public void setProduct_description(String product_description) {
	this.product_description = product_description;
}
public int getSupplier_id() {
	return supplier_id;
}
public void setSupplier_id(int supplier_id) {
	this.supplier_id = supplier_id;
}
   
   
}
