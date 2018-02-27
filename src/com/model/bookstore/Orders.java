package com.model.bookstore;

import java.sql.Date;

public class Orders {
	private int Id;
	private Date OrderDate;
	private int UserId;
	private float TotalPrice;
	private String Ordernumber;
	private int OrderStatus;
	public Orders(int id, Date orderDate, int userId, float totalPrice, String ordernumber, int orderStatus) {
		super();
		Id = id;
		OrderDate = orderDate;
		UserId = userId;
		TotalPrice = totalPrice;
		Ordernumber = ordernumber;
		OrderStatus = orderStatus;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public float getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getOrdernumber() {
		return Ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		Ordernumber = ordernumber;
	}
	public int getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		OrderStatus = orderStatus;
	}
	
}
