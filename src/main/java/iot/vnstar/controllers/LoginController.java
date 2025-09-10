package iot.vnstar.controllers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import iot.vnstar.dao.UserDAO;
import iot.vnstar.entity.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userDAO.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			// Redirect theo role
			if (user.getRole_id() == 1) {
				resp.sendRedirect(req.getContextPath() + "/user/home");
			} else if (user.getRole_id() == 2) {
				resp.sendRedirect(req.getContextPath() + "/manager/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			}
		} else {
			req.setAttribute("error", "Sai username hoặc password");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
