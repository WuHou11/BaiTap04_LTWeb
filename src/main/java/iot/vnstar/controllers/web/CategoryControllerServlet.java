package iot.vnstar.controllers.web;

import iot.vnstar.entity.Category;
import iot.vnstar.entity.User;
import iot.vnstar.services.CategoryService;
import iot.vnstar.services.impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/category/list", "/category/add", "/category/edit", "/category/delete"})
public class CategoryControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        User user = (User) req.getSession().getAttribute("user");

        if (uri.endsWith("list")) {
            List<Category> list = (user.getRole_id() == 2)
                    ? service.findByUser(user.getUser_id())
                    : service.findAll();
            req.setAttribute("categories", list);
            req.getRequestDispatcher("/WEB-INF/views/category-list.jsp").forward(req, resp);

        } else if (uri.endsWith("add")) {
            req.getRequestDispatcher("/WEB-INF/views/category-form.jsp").forward(req, resp);

        } else if (uri.endsWith("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category cate = service.findById(id);

            if (cate != null && (user.getRole_id() == 3 || cate.getUser().getUser_id() == user.getUser_id())) {
                req.setAttribute("category", cate);
                req.getRequestDispatcher("/WEB-INF/views/category-form.jsp").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            }

        } else if (uri.endsWith("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category cate = service.findById(id);

            if (cate != null && (user.getRole_id() == 3 || cate.getUser().getUser_id() == user.getUser_id())) {
                service.delete(id);
                resp.sendRedirect(req.getContextPath() + "/category/list");
            } else {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        User user = (User) req.getSession().getAttribute("user");

        String name = req.getParameter("cate_name");

        if (uri.endsWith("add")) {
            Category cate = new Category();
            cate.setCateName(name);
            cate.setUser(user);
            service.insert(cate);

        } else if (uri.endsWith("edit")) {
            int id = Integer.parseInt(req.getParameter("cate_id"));
            Category cate = service.findById(id);

            if (cate != null && (user.getRole_id() == 3 || cate.getUser().getUser_id() == user.getUser_id())) {
                cate.setCateName(name);
                service.update(cate);
            } else {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }

        resp.sendRedirect(req.getContextPath() + "/category/list");
    }
}
