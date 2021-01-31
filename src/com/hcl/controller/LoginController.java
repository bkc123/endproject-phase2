package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.UserDao;
/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "Sign in to get Started", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao loginDao;
	
	public void init() {
		loginDao= new UserDao();
	}
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        RequestDispatcher rd = null;
	        if (loginDao.validate(username, password)) {
	        	rd = request.getRequestDispatcher("SuccessController");
				rd.forward(request, response);
	        } else {
	        	rd= request.getRequestDispatcher("login.jsp");
				PrintWriter out = response.getWriter();
				rd.include(request, response);
				out.println("<center> <span style='color:red'>Invalid Credentials!!</span> </center>");
				
	        }
	    }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
*/

