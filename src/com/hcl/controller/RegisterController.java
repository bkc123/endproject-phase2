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
import com.hcl.model.*;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(description = "Registration", urlPatterns = { "/RegisterController" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
     
	public void init() {
		userDao = new UserDao();
	}
   
	
	protected void registerNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setfName(request.getParameter("fname"));
		user.setLname( request.getParameter("lname"));
		user.setEmail( request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setHobby(request.getParameter("hobby"));
		user.setCountry(request.getParameter("country"));
		userDao.saveUser(user);
		//RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
		//response.sendRedirect("userlist.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
		request.setAttribute("user", user);
		rd.forward(request, response);
		
		
		

		out.print("<br/> Congratulation! " + user.getfName() +" " + user.getLname()+ ". You have successfully registered.");
		out.print("<br/>" + "Here is your profile: <br/>" + user.toString());
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registerNewUser(request, response);
	}

}
