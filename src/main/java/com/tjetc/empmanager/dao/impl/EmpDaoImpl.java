package com.tjetc.empmanager.dao.impl;

import com.tjetc.empmanager.dao.EmpDao;
import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.domain.Emp;
import com.tjetc.empmanager.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public int insert(Emp emp) {
        Connection conn= DButil.getConnection();

        PreparedStatement pstmt=DButil.getPstmt(conn,"insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)",emp.getEmpno(),
                emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),
                emp.getSal(),emp.getComm(),emp.getDept().getDeptno());
        int i=DButil.update(pstmt);

        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int delete(int id) {
        Connection conn= DButil.getConnection();

        PreparedStatement pstmt=DButil.getPstmt(conn,"delete from emp where empno=?",id);
        int i=DButil.update(pstmt);

        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int update(Emp emp) {
        Connection conn= DButil.getConnection();

        PreparedStatement pstmt=DButil.getPstmt(conn,"update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?",
                emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),
                emp.getSal(),emp.getComm(),emp.getDept().getDeptno(),emp.getEmpno());
        int i=DButil.update(pstmt);

        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public List<Emp> selectAll() {
        Connection conn= DButil.getConnection();
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from emp e,dept d where e.deptno=ddeptno");
        ResultSet rs=DButil.query(pstmt);
        List<Emp> list=new ArrayList<Emp>();
        try{
            while (rs.next()){
                list.add(new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc"))));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    private Double format (Object o){
        if(o!=null){
            return Double.valueOf(o.toString());
        }else{
            return null;
        }
    }

    @Override
    public Emp selectByIdAndName(int empno, String ename) {
        Connection conn= DButil.getConnection();
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from emp e,dept d where empno=? and ename=? and e.deptno=ddeptno",empno,ename);
        ResultSet rs=DButil.query(pstmt);

        try{
            while (rs.next()){
                return new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc")));
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Emp> selectManager() {
        Connection conn= DButil.getConnection();
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from emp e,dept d where  empno in(select distinct mgr from emp where mgr is ont null) and e.deptno=ddeptno");
        ResultSet rs=DButil.query(pstmt);
        List<Emp> list=new ArrayList<Emp>();
        try{
            while (rs.next()){
                list.add(new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc"))));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Emp selectById(int id) {
        Connection conn= DButil.getConnection();
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from emp e,dept d where empno=? and e.deptno=ddeptno",id);
        ResultSet rs=DButil.query(pstmt);

        try{
            while (rs.next()){
                return new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc")));
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
