package com.bridgeit.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "arpana");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Emp e) {
		System.out.println("in save method of employeedao");
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into user(NAME,PASSWORD,EMAIL,COUNTRY) values (?,?,?,?)");
			ps.setString(1, e.getNAME());
			ps.setString(2, e.getPASSWORD());
			ps.setString(3, e.getEMAIL());
			ps.setString(4, e.getCOUNTRY());
			status=ps.executeUpdate();
			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return status;

	}

	public static int update(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update user set NAME=?,PASSWORD=?,EMAIL=?,COUNTRY=? where ID=?");

			ps.setString(1, e.getNAME());
			ps.setString(2, e.getPASSWORD());
			ps.setString(3, e.getEMAIL());
			ps.setString(4, e.getCOUNTRY());
			ps.setInt(5, e.getID());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int ID)

	{
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();

			PreparedStatement ps = con.prepareStatement("delete from user where id=?");
			ps.setInt(1, ID);
			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Emp getEmployeeById(int id) {
		Emp e = new Emp();

		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setID(rs.getInt(1));
				e.setNAME(rs.getString(2));
				e.setPASSWORD(rs.getString(3));
				e.setEMAIL(rs.getString(4));
				e.setCOUNTRY(rs.getString(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Emp> getAllEmployees() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setID(rs.getInt(1));
				e.setNAME(rs.getString(2));
				e.setPASSWORD(rs.getString(3));
				e.setEMAIL(rs.getString(4));
				e.setCOUNTRY(rs.getString(5));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
