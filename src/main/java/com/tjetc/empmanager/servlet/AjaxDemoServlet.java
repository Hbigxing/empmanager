package com.tjetc.empmanager.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "AjaxDemoServlet",urlPatterns = "/ajax")
public class AjaxDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求");
        String info=req.getParameter("info");
        System.out.println("接收到的info是："+info);
        PrintWriter out=resp.getWriter();
        out.write("你个垃圾~~~");
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求");

        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String info=req.getParameter("info");
        System.out.println("接收到info是："+info);
        System.out.println("name"+name+",password"+password);
        PrintWriter out=resp.getWriter();
        out.write("你个乐色~~~");
        out.flush();
    }

}
