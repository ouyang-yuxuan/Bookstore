package com.Dao.bookstore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connect.bookstore.jdbcutil;
import com.model.bookstore.Categories;
import com.model.bookstore.Publishers;
import com.model.bookstore.Userroles;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class OtherDao {
	public static ArrayList<Userroles> getUserroles() throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from userroles";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Userroles> userroles = new ArrayList<>();
		while (resultSet.next()) {
			Userroles userrole = new Userroles();
			userrole.setId(resultSet.getInt("Id"));
			userrole.setName(resultSet.getString("Name"));
			userroles.add(userrole);
		}
		jdbcutil.close(connection);
		return userroles;
	}
	public static ArrayList<Categories> getCategories() throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from categories";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		ArrayList<Categories> categories = new ArrayList<>();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Categories categorie = new Categories();
			categorie.setId(resultSet.getInt("id"));
			categorie.setName(resultSet.getString("Name"));
			categories.add(categorie);
		}
		jdbcutil.close(connection);
		return categories;
	}
	public static Categories getCategorie(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from categories";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		Categories categorie = new Categories();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			categorie.setId(resultSet.getInt("id"));
			categorie.setName(resultSet.getString("Name"));
		}
		jdbcutil.close(connection);
		return categorie;
	}
	public static boolean addCategories(int id,String name) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "INSERT categories VALUES(?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		boolean flag = preparedStatement.execute();
		return flag;
	}
	public static boolean deleteCategories(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "delete from categories where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
	

	
	public static ArrayList<Publishers>  getPublishers() throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from publishers";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		ArrayList<Publishers> publishers = new ArrayList<>();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Publishers publisher = new Publishers();
			publisher.setId(resultSet.getInt("id"));
			publisher.setName(resultSet.getString("Name"));
			publishers.add(publisher);
		}
		jdbcutil.close(connection);
		return publishers;
	}
	
	public static Publishers  getPublisher(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from publishers where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		Publishers publisher = new Publishers();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			publisher.setId(resultSet.getInt("id"));
			publisher.setName(resultSet.getString("Name"));
		}
		jdbcutil.close(connection);
		return publisher;
	}
	public static boolean addPublishers(int id,String name) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "INSERT pPublishers VALUES(?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
	public static boolean deletePublishers(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "delete from publishers where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}

}
