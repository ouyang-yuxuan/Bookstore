package com.model.bookstore;

public class Userroles {
	private int id;
	private String Name;
	public Userroles(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Userroles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
