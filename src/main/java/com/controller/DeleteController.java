package com.controller;

import java.io.IOException;
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

@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String[] list=request.getParameterValues("rowKey");
		String uname=request.getParameter("userName");
		System.out.println("uname="+uname);
		String buttonaction=request.getParameter("buttonaction");
		System.out.println("button action = "+buttonaction);
		RequestDispatcher rd = null;
		boolean status = false;
		if (buttonaction.equalsIgnoreCase("Delete")) {
			String[] list=request.getParameterValues("rowKey");
			if(list!=null) {
			for(String uName:list)
			{
			status=UserDao.delete(uName);	
			}} else
			{ System.out.println("uname is null");}
		}
		else if(buttonaction.equalsIgnoreCase("DeleteAll")) {
			
			status=UserDao.deleteAll();
		
			
		}
		else
		{	
		status=UserDao.delete(uname);
		}
		if(status) {
			System.out.println("View All");
			System.out.println(status+" deleted");

			List<User> ul=UserDao.viewAll();
			HttpSession session = request.getSession();
			session.setAttribute("list",ul);
			rd = request.getRequestDispatcher("View.jsp");



		}else{
			System.out.println("no record is selected");
			rd = request.getRequestDispatcher("View.jsp");
		}
		rd.forward(request, response);
	}

}
