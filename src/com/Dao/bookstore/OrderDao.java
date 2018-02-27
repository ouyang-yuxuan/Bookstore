package com.Dao.bookstore;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connect.bookstore.jdbcutil;
import com.model.bookstore.Orderbook;
import com.model.bookstore.Orders;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderDao {
	public static ArrayList<Orders> getOrders() throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from orders";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Orders> orders = new ArrayList<>();
		while (resultSet.next()) {
			Orders order = new Orders();
			order.setId(resultSet.getInt("Id"));
			order.setOrderDate(resultSet.getDate("OrderDate"));
			order.setUserId(resultSet.getInt("UserId"));
			order.setTotalPrice(resultSet.getFloat("TotalPrice"));
			order.setOrdernumber(resultSet.getString("Ordernumber"));
			order.setOrderStatus(resultSet.getInt("OrderStatus"));
			orders.add(order);
		}
		jdbcutil.close(connection);
		return orders;
	}
	public static int addOrder(int UserId,float TotalPrice,int OrderStatus) throws SQLException {
		Connection connection = jdbcutil.getConection();
		Date date = new Date(new java.util.Date().getTime());
		String Ordernumber = String.valueOf(UserId)+date;
		String sql1 = "insert orders(OrderDate,UserId,TotalPrice,Ordernumber,OrderStatus) value(?,?,?,?,?)";
		PreparedStatement preparedStatement1 = (PreparedStatement) connection.prepareStatement(sql1);
		preparedStatement1.setDate(1, date);
		preparedStatement1.setInt(2, UserId);
		preparedStatement1.setFloat(3, TotalPrice);
		preparedStatement1.setString(4, Ordernumber);
		preparedStatement1.setInt(5, 1);
		preparedStatement1.execute();
		String sql2 = "select id from orders where Ordernumber = ?";
		PreparedStatement preparedStatement2 = (PreparedStatement) connection.prepareStatement(sql2);
		preparedStatement2.setString(1, Ordernumber);
		ResultSet resultSet = preparedStatement2.executeQuery();
		int id = 0;
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		jdbcutil.close(connection);
		return id;
	}
	public static Orders getOrder(int oderId) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from orders where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, oderId);
		ResultSet resultSet = preparedStatement.executeQuery();
		Orders order = new Orders();
		while (resultSet.next()) {
			order.setId(resultSet.getInt("Id"));
			order.setOrderDate(resultSet.getDate("OrderDate"));
			order.setUserId(resultSet.getInt("UserId"));
			order.setTotalPrice(resultSet.getFloat("TotalPrice"));
			order.setOrdernumber(resultSet.getString("Ordernumber"));
			order.setOrderStatus(resultSet.getInt("OrderStatus"));
		}
		jdbcutil.close(connection);
		return order;
	}
	public static ArrayList<Orders> getOrderByUser(int userid) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from orders where userid = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, userid);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Orders> orders = new ArrayList<>();
		while (resultSet.next()) {
			Orders order = new Orders();
			order.setId(resultSet.getInt("Id"));
			order.setOrderDate(resultSet.getDate("OrderDate"));
			order.setUserId(resultSet.getInt("UserId"));
			order.setTotalPrice(resultSet.getFloat("TotalPrice"));
			order.setOrdernumber(resultSet.getString("Ordernumber"));
			order.setOrderStatus(resultSet.getInt("OrderStatus"));
			orders.add(order);
		}
		jdbcutil.close(connection);
		return orders;
	}
	public static boolean updateOrders(int id,float TotalPrice,int OrderStatus) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "updata orders set TotalPrice=?,OrderStatus=? where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setFloat(1, TotalPrice);
		preparedStatement.setInt(2, OrderStatus);
		preparedStatement.setInt(3, id);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
	public static boolean deleteOrders(int id) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "delete from orders where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
	
	
	public static ArrayList<Orderbook> getOrderBooks(int OrderID) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "select * from orderbook where OrderID = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, OrderID);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Orderbook> orderbooks = new ArrayList<>();
		while (resultSet.next()) {
			Orderbook orderbook = new Orderbook();
			orderbook.setId(resultSet.getInt("Id"));
			orderbook.setOrderID(resultSet.getInt("orderID"));
			orderbook.setBookID(resultSet.getInt("BookID"));
			orderbook.setQuantity(resultSet.getInt("Quantity"));
			orderbook.setUnitPrice(resultSet.getFloat("UnitPrice"));
			orderbooks.add(orderbook);
		}
		jdbcutil.close(connection);
		return orderbooks;
	}
	public static boolean updateOrderbooks(int id,int Quantity,float UnitPrice) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "updata orderbook set TotalPrice=?,OrderStatus=? where id = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, Quantity);
		preparedStatement.setFloat(2, UnitPrice);
		preparedStatement.setInt(3, id);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
	public static boolean addOrderbooks(int BookID,int OrderID,int Quantity,float UnitPrice) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "insert orderbook(BookID,OrderID,Quantity,UnitPrice) value(?,?,?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, BookID);
		preparedStatement.setInt(2, OrderID);
		preparedStatement.setInt(3, Quantity);
		preparedStatement.setFloat(4, UnitPrice);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
	public static boolean deleteOrderbooks(int OrderID) throws SQLException {
		Connection connection = jdbcutil.getConection();
		String sql = "delete from orderbook where OrderID = ?";
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, OrderID);
		boolean flag = preparedStatement.execute();
		jdbcutil.close(connection);
		return flag;
	}
	
}
