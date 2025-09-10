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

@WebServlet("/admin/home")
public class AdminHome extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryDao dao = new CategoryDao();
    public AdminHome() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        List<Category> list = dao.findAll();
        req.setAttribute("categories", list);
        req.getRequestDispatcher("/WEB-INF/views/admin-home.jsp").forward(req, resp);
    }
}
