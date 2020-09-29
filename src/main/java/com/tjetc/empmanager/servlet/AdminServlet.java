package com.tjetc.empmanager.servlet;

import com.tjetc.empmanager.domain.Admin;
import com.tjetc.empmanager.service.AdminService;
import com.tjetc.empmanager.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    private AdminService service;

    public AdminServlet() {
        this.service = new AdminServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String account=req.getParameter("account");
        String password=req.getParameter("password");
        Admin admin=this.service.login(account,password);
        if(admin==null){
            req.setAttribute("message","登录失败");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            HttpSession session=req.getSession();
            session.setAttribute("admin",admin);
            int num=(Integer) this.getServletContext().getAttribute("num");
            this.getServletContext().setAttribute("num",num+1);
            resp.sendRedirect("index.jsp");
        }
    }
}
