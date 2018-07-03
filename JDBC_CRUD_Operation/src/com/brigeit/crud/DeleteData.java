/*
 * Purpose:-Delete a Data in the Datable
 * 
 * Author:-Arpana Kumari
 * Version:1.0
 * Since: 22 June, 2018
 */
package com.brigeit.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgeit.util.DBConnection;

public class DeleteData {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			con = DBConnection.getConnection();
			System.out.println("driver registered");
			System.out.println("connection established");
			stmt = con.createStatement();
			System.out.println("create statement");

			String sql = "DELETE FROM student WHERE id = 4";
			stmt.executeUpdate(sql);
		}

		catch (SQLException | ClassNotFoundException e) {
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
