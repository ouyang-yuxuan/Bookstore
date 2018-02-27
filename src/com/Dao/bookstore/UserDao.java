package com.Dao.bookstore;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connect.bookstore.jdbcutil;
import com.model.bookstore.Users;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao {

	public static Users loginQuery(String LoginId,String LoginPwd) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from users where LoginId=? and LoginPwd=?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, LoginId);
		preparedStatement.setString(2, LoginPwd);
		ResultSet resultSet = preparedStatement.executeQuery();
		Users user = null;
		if (resultSet.next()) {
			user = new Users();
			user.setId(resultSet.getInt("Id")); 
			user.setLoginId(resultSet.getString("LoginId"));
			user.setLoginPwd(resultSet.getString("LoginPwd"));
			user.setName(resultSet.getString("Name"));
			user.setAddress(resultSet.getString("Address"));
			user.setPhone(resultSet.getString("Phone"));
			user.setMail(resultSet.getString("Mail"));
			user.setCreateDate(resultSet.getDate("CreateDate"));
			user.setPermissionId(resultSet.getInt("PermissionId"));
		}
		jdbcutil.close(connection);
		return user;
	}	
	public static Users loginQueryByLoginId(String LoginId) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from users where LoginId=?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, LoginId);
		ResultSet resultSet = preparedStatement.executeQuery();
		Users user = null;
		if (resultSet.next()) {
			user = new Users();
			user.setId(resultSet.getInt("Id")); 
			user.setLoginId(resultSet.getString("LoginId"));
			user.setLoginPwd(resultSet.getString("LoginPwd"));
			user.setName(resultSet.getString("Name"));
			user.setAddress(resultSet.getString("Address"));
			user.setPhone(resultSet.getString("Phone"));
			user.setMail(resultSet.getString("Mail"));
			user.setCreateDate(resultSet.getDate("CreateDate"));
			user.setPermissionId(resultSet.getInt("PermissionId"));
		}
		jdbcutil.close(connection);
		return user;
	}	
	public static Users queryUserById(int Id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from users where Id=?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, Id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Users user = null;
		if (resultSet.next()) {
			user = new Users();
			user.setId(resultSet.getInt("Id")); 
			user.setLoginId(resultSet.getString("LoginId"));
			user.setLoginPwd(resultSet.getString("LoginPwd"));
			user.setName(resultSet.getString("Name"));
			user.setAddress(resultSet.getString("Address"));
			user.setPhone(resultSet.getString("Phone"));
			user.setMail(resultSet.getString("Mail"));
			user.setCreateDate(resultSet.getDate("CreateDate"));
			user.setPermissionId(resultSet.getInt("PermissionId"));
		}
		jdbcutil.close(connection);
		return user;
	}	
	public static ArrayList<Users> getUsers() throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from users";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Users> users = new ArrayList<>();
		while (resultSet.next()) {
			Users user = new Users();
			user.setId(resultSet.getInt("Id")); 
			user.setLoginId(resultSet.getString("LoginId"));
			user.setLoginPwd(resultSet.getString("LoginPwd"));
			user.setName(resultSet.getString("Name"));
			user.setAddress(resultSet.getString("Address"));
			user.setPhone(resultSet.getString("Phone"));
			user.setMail(resultSet.getString("Mail"));
			user.setCreateDate(resultSet.getDate("CreateDate"));
			user.setPermissionId(resultSet.getInt("PermissionId"));
			users.add(user);
		}
		jdbcutil.close(connection);
		return users;
	}

	public static ArrayList<Users> QueryUsersByLoginId(String LoginId) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from users where loginId like ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, "%"+LoginId+"%");
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Users> users = new ArrayList<>();
		if (resultSet.next()) {
			Users user = new Users();
			user.setId(resultSet.getInt("Id")); 
			user.setLoginId(resultSet.getString("LoginId"));
			user.setLoginPwd(resultSet.getString("LoginPwd"));
			user.setName(resultSet.getString("Name"));
			user.setAddress(resultSet.getString("Address"));
			user.setPhone(resultSet.getString("Phone"));
			user.setMail(resultSet.getString("Mail"));
			user.setCreateDate(resultSet.getDate("CreateDate"));
			user.setPermissionId(resultSet.getInt("PermissionId"));
			users.add(user);
		}
		jdbcutil.close(connection);
		return users;
	}
	
	public static boolean addUser(String loginId, String loginPwd, String name, String address, String phone, String mail) throws SQLException {
		Connection connection = jdbcutil.getConection();
		Date date = new Date(new java.util.Date().getTime());
		String sql = "insert users(loginId,loginPwd,name,address,phone,mail,createDate) value(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, loginId);
		preparedStatement.setString(2, loginPwd);
		preparedStatement.setString(3, name);
		preparedStatement.setString(4, address);
		preparedStatement.setString(5, phone);
		preparedStatement.setString(6, mail);
		preparedStatement.setDate(7, date);
		int flag = preparedStatement.executeUpdate();
		jdbcutil.close(connection);
		return flag==1?true:false;
	}

	public static boolean updateUser(int id,String loginId, String loginPwd, String name, String address, String phone, String mail) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "update users set loginId=?,loginPwd=?,name=?,address=?,phone=?,mail=? where id=?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, loginId);
		preparedStatement.setString(2, loginPwd);
		preparedStatement.setString(3, name);
		preparedStatement.setString(4, address);
		preparedStatement.setString(5, phone);
		preparedStatement.setString(6, mail);
		preparedStatement.setInt(7, id);
		int flag = preparedStatement.executeUpdate();
		System.out.println(flag);
		jdbcutil.close(connection);
		return flag==1?true:false;
	}
	public static boolean updateUser(int id,String name, String address, String phone) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "update users set name=?,address=?,phone=? where id=?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, address);
		preparedStatement.setString(3, phone);
		preparedStatement.setInt(4, id);
		int flag = preparedStatement.executeUpdate();
		System.out.println(flag);
		jdbcutil.close(connection);
		return flag==1?true:false;
	}
	public static boolean deleteUser(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "DELETE FROM users WHERE id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
}
