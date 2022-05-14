package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String buttonaction = request.getParameter("buttonaction");

		System.out.println("buttonaction="+buttonaction);




		RequestDispatcher rd = null;
		if(buttonaction.equalsIgnoreCase("Edit")) {
			System.out.println("edit");
			//List<User> ul=UserDao.viewAll();
			HttpSession session = request.getSession();
		session.getAttribute("user");
			rd = request.getRequestDispatcher("Update.jsp");

		}

		else if(buttonaction.equalsIgnoreCase("View")) {
			System.out.println("View All");
			List<User> ul=UserDao.viewAll();
			HttpSession session = request.getSession();
			session.setAttribute("list",ul);
			rd = request.getRequestDispatcher("View.jsp");

		}
		else if(buttonaction.equalsIgnoreCase("Update")) {
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String date = request.getParameter("dob");
			Date dob = CommonDate.getDate(date);

			String[] langList = request.getParameterValues("lang");
			System.out.println(langList.toString());
			String lang = "";
			for (int i = 0; i < langList.length; i++) {
				lang +=  langList[i] + " ";
				System.out.println(lang);
						}
			String gender = request.getParameter("gender");
			String username = request.getParameter("username");
			String pswd = request.getParameter("password");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String address = request.getParameter("address");
			String type = request.getParameter("type");
			rd = request.getRequestDispatcher("Update");
			System.out.println(lang+"++++++++++");
			User user = new User(name, age, dob, lang, gender, username, pswd, email, contact, address, type);
			System.out.println(user);

			if (user!=null) {
				HttpSession session = request.getSession();
				session.getAttribute("user");
				boolean status = UserDao.update(user);

				if(status)
				{
					System.out.println(status + " row updated");
					System.out.println("----"+user);
					List<User> ul=UserDao.view(user);
					session.setAttribute("list",ul);
					rd = request.getRequestDispatcher("View.jsp");


				}

			} 
		}
		rd.forward(request, response);
	}
}
