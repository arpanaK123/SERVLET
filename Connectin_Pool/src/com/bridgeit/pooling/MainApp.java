package com.bridgeit.pooling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {

	static Connection con = null;

	public static void main(String[] args) throws SQLException {

		con = C3P0DataSource.getInstance().getConnection();

		showAll();
	}

	public static void showAll() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM books");
		ResultSetMetaData metadata = rs.getMetaData();

		while (rs.next()) {
			System.out.println(rs.getString("isbn"));
			System.out.println(rs.getString("title"));
			System.out.println(rs.getString("edition"));
			System.out.println(rs.getString("price"));

		}
	}

}
