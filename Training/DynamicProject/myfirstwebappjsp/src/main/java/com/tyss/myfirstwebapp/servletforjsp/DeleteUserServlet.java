package com.tyss.myfirstwebapp.servletforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.myfirstwebapp.services.UserServices;
import com.tyss.myfirstwebapp.services.UserServicesImpl;

@WebServlet("/deleteUser2")
public class DeleteUserServlet extends HttpServlet {
	private UserServices service = new UserServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if (session != null) {
			int userId = Integer.parseInt(req.getParameter("uid"));
			boolean isDeleted = service.deleteUser(userId);
			if (isDeleted) {
				req.setAttribute("msg", "user " + userId + "has been deleted");
			} else {
				req.setAttribute("msg", "user " + userId + "not found in database");
			}
			req.getRequestDispatcher("./deleteUserJsp.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Please login first");
			req.getRequestDispatcher("./loginJsp").forward(req, resp);

		}
	}

}
