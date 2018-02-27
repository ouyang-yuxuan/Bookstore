package com.connect.bookstore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class jdbcutil {
	private static String DRIVER_CLASS;
	private static String URL;
	private static String USERRNAME;
	private static String PASSWORD;
	private static Properties p = new Properties();
	static {
		try {
			InputStream in = jdbcutil.class.getClassLoader().getResourceAsStream("bookstore.properties");
			p.load(in);
			DRIVER_CLASS = p.getProperty("driver");
			URL = p.getProperty("url");
			USERRNAME = p.getProperty("user");
			PASSWORD = p.getProperty("pass");
			Class.forName(DRIVER_CLASS);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public static Connection getConection() {
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(URL, USERRNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}