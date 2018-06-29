package com.bridgeit.operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet") 
public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("NAME");
		String password = request.getParameter("PASSWORD");
		String email = request.getParameter("EMAIL");
		String country = request.getParameter("COUNTRY");

		Emp e = new Emp();
		e.setNAME(name);
		e.setPASSWORD(password);
		e.setEMAIL(email);
		e.setCOUNTRY(country);

		int status = EmpDao.save(e);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();

	}

}
