package com.tjetc.empmanager.servlet;

import com.tjetc.empmanager.domain.Goods;
import com.tjetc.empmanager.service.GoodsService;
import com.tjetc.empmanager.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GoodsServlet extends HttpServlet {
    private GoodsService service;

    public GoodsServlet() {
        this.service = new GoodsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        if("add".equals(op)){
            this.add(req,resp);
        }else if("findAll".equals(op)){
            this.findAll(req,resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> all=new ArrayList<>();
        req.setAttribute("all",all);
        req.getRequestDispatcher("show.AllGoods.jsp").forward(req,resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name=req.getParameter("name");
        String price=req.getParameter("price");
        Part part=req.getPart("img");
        String oldName=part.getSubmittedFileName();
        String newName="/"+
                UUID.randomUUID().toString().replaceAll("-","").toUpperCase()
                +oldName.substring(oldName.lastIndexOf("."));
        String path=this.getServletContext().getRealPath("/upload");
        File f=new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        part.write(path+newName);
        String s=this.service.addGoods(new Goods(1,name,"/upload"+newName,Double.valueOf(price)));
        System.out.println(s);
        resp.sendRedirect("addGoods.jsp");

    }
}
