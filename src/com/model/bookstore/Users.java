package com.model.bookstore;

import java.sql.Date;

public class Users {
	private int Id;
	private String LoginId;
	private String LoginPwd;
	private String Name;
	private String Address;
	private String Phone;
	private String Mail;
	private Date CreateDate;
	private int PermissionId;
	
	public Users(int id, String loginId, String loginPwd, String name, String address, String phone, String mail,
			Date createDate, int permissionId) {
		super();
		Id = id;
		LoginId = loginId;
		LoginPwd = loginPwd;
		Name = name;
		Address = address;
		Phone = phone;
		Mail = mail;
		CreateDate = createDate;
		PermissionId = permissionId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}

	public String getLoginPwd() {
		return LoginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public int getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(int permissionId) {
		PermissionId = permissionId;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

}
