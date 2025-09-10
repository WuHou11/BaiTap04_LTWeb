package iot.vnstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import iot.vnstar.dao.CategoryDao;
import iot.vnstar.entity.Category;
import iot.vnstar.entity.User;

@WebServlet("/manager/home")
public class ManagerHome extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryDao dao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            List<Category> list = dao.findByUser(user.getUser_id());
            req.setAttribute("categories", list);

            // ✅ debug log
            System.out.println("Login user id: " + user.getUser_id());
            System.out.println("Categories size = " + list.size());
        } else {
            System.out.println("No user in session!");
        }

        req.getRequestDispatcher("/WEB-INF/views/manager-home.jsp").forward(req, resp);
    }
}
