package com.learning.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println("This "+ this.getServletName()+" has Started");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		System.out.println("Servlet Do get Method");
		response.setContentType("text/html");
		response.getWriter().println("<h1> First Servlet </h1>");
	}
	
	public void destroy(){
		System.out.println("This "+ this.getServletName()+" has Stopped");
	}
	
}
