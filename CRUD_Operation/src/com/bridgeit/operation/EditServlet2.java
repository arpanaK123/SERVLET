package com.bridgeit.operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")  

public class EditServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("ID");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("NAME");
		String password = request.getParameter("PASSWORD");
		String email = request.getParameter("EMAIL");
		String country = request.getParameter("COUNTRY");

		Emp e = new Emp();
		e.setID(id);
		e.setNAME(name);
		e.setPASSWORD(password);
		e.setEMAIL(email);
		e.setCOUNTRY(country);

		int status = EmpDao.update(e);
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();

	}

}
