package com.tjetc.empmanager.dao.impl;

import com.tjetc.empmanager.dao.DeptDao;
import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    public int insert(Dept dept) {
        //调用Dbutil获取连接对象
        Connection conn = DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DButil.getPstmt(conn, "insert into dept(deptno,dname,loc) values(?,?,?)",
                dept.getDeptno(), dept.getDname(), dept.getLoc());
        //执行插入操作
        int i = DButil.update(pstmt);
        //关闭资源
        DButil.close(conn,pstmt,null);
        return i;
    }

    public int delete(int id) {
        //调用Dbutil获取连接对象
        Connection conn = DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DButil.getPstmt(conn,"DELETE FROM dept WHERE deptno=?",id);
        //执行插入操作
        int i = DButil.update(pstmt);
        //关闭资源
        DButil.close(conn,pstmt,null);
        return i;
    }

    public int update(Dept dept) {
        //调用Dbutil获取连接对象
        Connection conn=DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DButil.getPstmt(conn,"UPDATE dept set loc=? WHERE dname=?",dept.getLoc(),dept.getDname());
        //执行插入操作
        int i = DButil.update(pstmt);
        //关闭资源
        DButil.close(conn,pstmt,null);
        return i;
    }

    public List<Dept> selectAll() {
        //调用Dbutil获取连接对象
        Connection conn=DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from dept");
        //执行查询语句
        ResultSet rs=DButil.query(pstmt);
        //准备集合
        List<Dept> depts=new ArrayList<Dept>();
        try{
            while (rs.next()){
                depts.add(new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")));
            }
            return depts;
        }catch(Exception e){
            return depts;
        }
    }

    public Dept selectById(int id) {
        //调用Dbutil获取连接对象
        Connection conn=DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from dept where deptno=?",id);
        //执行查询语句
        ResultSet rs=DButil.query(pstmt);
        try{
            while (rs.next()){
                return new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc"));
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    public Dept selectByName(String name) {
        //调用Dbutil获取连接对象
        Connection conn=DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from dept where dname=?",name);
        //执行查询语句
        ResultSet rs=DButil.query(pstmt);
        try{
            while (rs.next()){
                return new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc"));
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    public List<Dept> selectByLikeName(String name) {
        //调用Dbutil获取连接对象
        Connection conn=DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from dept where dname like ?","%"+name+"%");
        //执行查询语句
        ResultSet rs=DButil.query(pstmt);
        //准备集合
        List<Dept> depts=new ArrayList<Dept>();
        try{
            while (rs.next()){
                depts.add(new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")));
            }
            return depts;
        }catch(Exception e){
            return depts;
        }
    }
}
