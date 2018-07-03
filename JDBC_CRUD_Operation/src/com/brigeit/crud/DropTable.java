package com.brigeit.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgeit.util.DBConnection;

public class DropTable {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getConnection();
			System.out.println("driver registered");
			System.out.println("connection established");
			stmt = con.createStatement();
			System.out.println("create statement");

			String sql = "DROP TABLE user ";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");

			stmt.executeUpdate(sql);
			System.out.println("Table  deleted in given database...");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		System.out.println("Operation Successfull...");
	}
}
