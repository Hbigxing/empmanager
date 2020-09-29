package com.tjetc.empmanager.servlet;

//import com.google.gson.Gson;
import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.service.DeptService;
import com.tjetc.empmanager.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name="DeptServlet",urlPatterns = "/DeptServlet")
public class DeptServlet extends HttpServlet {

    //创建业务层
    private DeptService service;

    public DeptServlet(){
        this.service=new DeptServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        if ("addDept".equals(op)){
            this.addDept(req,resp);
        }else if("findAll".equals(op)){
            this.findAll(req,resp);
        }else if("like".equals(op)){
            this.like(req,resp);
        }else if("ajax".equals(op)){
            this.ajax(req,resp);
        }
    }

    private void ajax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
         String deptno=req.getParameter("deptno");
         String dname=req.getParameter("dname");
         PrintWriter out=resp.getWriter();
         if(deptno!=null){
             Dept d=this.service.findById(deptno);
             out.write(d!=null?"1":"0");
             out.flush();
         }else if(dname!=null){
             Dept d=this.service.findByName(dname);
             out.write(d!=null?"1":"0");
             out.flush();
         }
    }

    private void like(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name=req.getParameter("name");
        System.out.println(name);
        List<Dept> list=this.service.findByLikeName(name);
        System.out.println(list);
        PrintWriter out=resp.getWriter();
        /*Gson gson=new Gson();
        String jsonString =gson.toJson(list);*/
        //out.write(jsonString);
        out.flush();
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Dept> all=this.service.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("manger/showAll.jsp").forward(req,resp);
    }

    private void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno=req.getParameter("deptno");
        String dname=req.getParameter("dname");
        String loc=req.getParameter("loc");

        String info=service.addDept(deptno,dname,loc);

        req.setAttribute("info",info);

        req.getRequestDispatcher("manger/message.jsp").forward(req,resp);
    }
}
