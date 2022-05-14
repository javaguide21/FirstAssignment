package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dto.User;
import com.util.CommonDate;

@WebServlet("/SignUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String date = request.getParameter("dob");
		Date dob = CommonDate.getDate(date);
		
		String[] langList = request.getParameterValues("lang");
		String lang = "";
		for (int i = 0; i < langList.length; i++) {
			lang += langList[i] + " ";
		}
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		String pswd = request.getParameter("password");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String type = request.getParameter("type");

		User user = new User(name, age, dob, lang, gender, username, pswd, email, contact, address, type);
		System.out.println(user);
		if (UserDao.usernameCheck(user.getUsername())) {
			System.out.println("Try with another username");
		} else {
			boolean status = UserDao.insert(user);

			if (status) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				System.out.println(" row inserted");
				RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
				rd.forward(request, response);
			}
		else {
			
			System.out.println(" Existing user");
			RequestDispatcher rd = request.getRequestDispatcher("Register.html");
			rd.forward(request, response);
		}
	}
}
}