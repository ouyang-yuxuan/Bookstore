package com.model.bookstore;

public class Publishers {
	private int id;
	private String Name;
	public Publishers(int id, String name) {
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
	public Publishers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
