/*
 * Purpose:-Read only One Record from the DataTable
 * 
 * Author:-Arpana Kumari
 * Version:-1.0
 * Since:-22 June, 2018
 */
package com.brigeit.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgeit.util.DBConnection;

public class ReadOneData {
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

			String query = "SELECT ID, FIRST_NAME, LAST_NAME, ADDRESS from STUDENT WHERE ID=1";
			result = stmt.executeQuery(query);

			while (result.next()) {
				int id = result.getInt("ID");
				String firstname = result.getString("FIRST_NAME");
				String lastName = result.getString("LAST_NAME");
				String address = result.getString("ADDRESS");

				System.out.print(" ID: " + id + "\n");
				System.out.print(" FIRST_NAME: " + firstname + "\n");
				System.out.print(" LAST_NAME: " + lastName + "\n");
				System.out.print(" ADDRESS: " + address + "\n");

			}
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
