package iot.vnstar.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import iot.vnstar.entity.User;

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();
        HttpSession session = req.getSession(false);
        User u = (session != null) ? (User) session.getAttribute("user") : null;

        if (path.startsWith(req.getContextPath() + "/admin") && (u == null || u.getRole_id() != 3)) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        if (path.startsWith(req.getContextPath() + "/manager") && (u == null || u.getRole_id() != 2)) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        if (path.startsWith(req.getContextPath() + "/user") && (u == null || u.getRole_id() != 1)) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}
