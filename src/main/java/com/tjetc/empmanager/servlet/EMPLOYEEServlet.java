package com.tjetc.empmanager.servlet;

import com.tjetc.empmanager.domain.EMPLOYEE;
import com.tjetc.empmanager.service.EMPLOYEEService;
import com.tjetc.empmanager.service.impl.EMPLOYEEServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "EMPLOYEEServlet",urlPatterns = "/EMPLOYEEServlet")
public class EMPLOYEEServlet extends HttpServlet {
    private EMPLOYEEService employeeService;

    public EMPLOYEEServlet(){
        this.employeeService=new EMPLOYEEServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        System.out.println(op);
        if ("findById".equals(op)){
            this.findById(req,resp);
        }
    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EMPLOYEE> employeeAll=new ArrayList<EMPLOYEE>();
        employeeAll=this.employeeService.finAll();
        System.out.println(employeeAll);

        req.setAttribute("employeeAll",employeeAll);
        req.getRequestDispatcher("manger/employee.jsp").forward(req,resp);
    }
}
