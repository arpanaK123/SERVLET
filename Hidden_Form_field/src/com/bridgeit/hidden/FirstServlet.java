package com.bridgeit.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");

			out.print("welcome " + n);

			// creating form that have invisible textfield
			out.print("<form action='servlet2'>");
			out.print("<input type='hidden' name='uname' value='\"+n+\"'>");
			out.print("<inpu type='submit' value='go'>");
			out.print("</form>");

			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
