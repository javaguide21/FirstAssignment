package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dto.User;

@WebServlet("/LogIn")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pswd = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(pswd);
		boolean status = UserDao.usernameCheck(user.getUsername());
		if(status) {
			user=UserDao.logInCheck(user);
			if(user!=null) {
				System.out.println("Login Success");
				HttpSession session = request.getSession();
				session.setAttribute("user",user);
				RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
				rd.forward(request, response);
				
			}else {
				System.out.println("Login Failure");
			}
			
			
		}else {
			System.out.println("Invalid username");
		}

	}

}
