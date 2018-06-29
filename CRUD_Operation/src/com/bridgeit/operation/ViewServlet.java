package com.bridgeit.operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")

public class ViewServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<a href='Index.html'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");

		List<Emp> list = EmpDao.getAllEmployees();

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th> <th>Edit</th><th>Delete</th></tr>");
		for (Emp e : list) {
			out.print("<tr><td>" + e.getID() + "</td><td>" + e.getNAME() + "</td><td>" + e.getPASSWORD() + "</td><td>"
					+ e.getEMAIL() + "</td><td>" + e.getCOUNTRY() + "</td><td><a href='EditServlet?id=" + e.getID()
					+ "'>edit</a></td><td><a href='DeleteServlet?id=" + e.getID() + "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();

	}

}
