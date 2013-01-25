package com.glp.domain;

import java.util.Date;

public class Orders {
    private int id;
    private Date order_date;
    private String price;
    private String purchase_number;
    private String shipment_id;
    private String PurchaseHistory_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPurchase_number() {
		return purchase_number;
	}
	public void setPurchase_number(String purchase_number) {
		this.purchase_number = purchase_number;
	}
	public String getShipment_id() {
		return shipment_id;
	}
	public void setShipment_id(String shipment_id) {
		this.shipment_id = shipment_id;
	}
	public String getPurchaseHistory_id() {
		return PurchaseHistory_id;
	}
	public void setPurchaseHistory_id(String purchaseHistory_id) {
		PurchaseHistory_id = purchaseHistory_id;
	}
    
    
    
}
