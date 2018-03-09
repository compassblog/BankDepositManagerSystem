package com.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String url = "jdbc:mysql://localhost:3306/bankmanagersystem";

	public static Connection getDBC() throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, "root", "root");
		return conn;
	}
}
