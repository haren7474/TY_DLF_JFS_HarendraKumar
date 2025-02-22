package com.tyss.myfirstwebapp.servletforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.myfirstwebapp.beans.UserBean;
import com.tyss.myfirstwebapp.services.UserServices;
import com.tyss.myfirstwebapp.services.UserServicesImpl;

@WebServlet("/addUserServlet2")
public class AddUserServlet extends HttpServlet {
	private UserBean user = null;
	private UserServices service = new UserServicesImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {
			// Valid Session
			int userId = Integer.parseInt(req.getParameter("uid"));

			user = new UserBean();
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setUserid(userId);
			user.setUsername(req.getParameter("username"));
			if (service.addUser(user)) {
				req.setAttribute("msg", "User with ID " + userId + " has been added");
			} else {
				req.setAttribute("msg", "User with ID " + userId + " could not be added");
			}

			req.getRequestDispatcher("./AddUserJsp.jsp").forward(req, resp);
		} else {
			// Invalid Session
			req.setAttribute("msg", "Please login first");
			req.getRequestDispatcher("./loginJsp").forward(req, resp);
		}
	}
}
