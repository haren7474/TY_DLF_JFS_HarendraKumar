package com.tyss.myfirstwebapp.servletforjsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.myfirstwebapp.beans.UserBean;
import com.tyss.myfirstwebapp.services.UserServices;
import com.tyss.myfirstwebapp.services.UserServicesImpl;

@WebServlet("/fetchAllUsersServlet")
public class FetchAllUsersServlet extends HttpServlet {
	private UserServices service = new UserServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");

		if (session != null) {
			// Valid Session
			List<UserBean> list = service.getAllUsers();

			if (list.size() > 0) {
				// List having data
				req.setAttribute("userList", list);
				req.getRequestDispatcher("./fetchAllUsersJsp.jsp").forward(req, resp);

			} else {
				// Empty List
				req.setAttribute("msg", "No Data, Please add user first!!!!");
				req.getRequestDispatcher("./AddNewUserJsp").forward(req, resp);

			}
		} else {
			// Invalid Session
			req.setAttribute("msg", "Please login first.. Redirecting to Login page");
			req.getRequestDispatcher("./loginJsp").forward(req, resp);
		}

		out.println("</body>");
		out.println("</html>");
	}
}
