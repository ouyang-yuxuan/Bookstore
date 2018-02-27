package com.model.bookstore;

public class Orderbook {
	private int Id;
	private int OrderID;
	private int BookID;
	private int Quantity;
	private float UnitPrice;
	public Orderbook(int id, int orderID, int bookID, int quantity, float unitPrice) {
		super();
		Id = id;
		OrderID = orderID;
		BookID = bookID;
		Quantity = quantity;
		UnitPrice = unitPrice;
	}
	public Orderbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public float getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}
	
}
