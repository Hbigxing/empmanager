package com.tjetc.empmanager.listener;

import com.tjetc.empmanager.util.DButil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebListener("VisitCountListener")
public class VisitCountListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("服务器启动，context对象开始运行");
        Connection conn= DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn, "select num from count ");
        ResultSet rs = DButil.query(pstmt);
        int num=0;
        try {
            if(rs.next()){
                num=rs.getInt("num");
            }
            ServletContext sc=servletContextEvent.getServletContext();
            sc.setAttribute("num",num);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(conn,pstmt,rs);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("服务器关闭，context对象正在销毁");
        Connection conn=DButil.getConnection();
        PreparedStatement pstmt=DButil.getPstmt(conn,"update count set num=?",servletContextEvent.getServletContext().getAttribute("num"));
        DButil.update(pstmt);
    }
}
