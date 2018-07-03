package com.bridgeit.pooling;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0DataSource {

	private static C3P0DataSource datasourcer;
	private ComboPooledDataSource comboPooledDataSource;

	private  C3P0DataSource() {
		try {
			comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");

			comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/books");

			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("arpana");

		} catch (PropertyVetoException e) {

			e.printStackTrace();
		}
		
	}

	public static C3P0DataSource getInstance() {
		if (datasourcer == null) {
			datasourcer = new C3P0DataSource();
		}
		return datasourcer;

	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = comboPooledDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return con;
	}
}
