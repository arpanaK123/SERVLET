package com.bridgeit.url;

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

			// appending the username in the query string
			out.print("<a href='servlet2?uname=" + n + "'>visit</a>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
