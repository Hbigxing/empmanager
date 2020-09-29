package com.tjetc.empmanager.dao.impl;

import com.tjetc.empmanager.dao.EMPLOYEEDao;
import com.tjetc.empmanager.domain.EMPLOYEE;
import com.tjetc.empmanager.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EMPLOYEEDaoImpl implements EMPLOYEEDao {
    @Override
    public EMPLOYEE selectByName(String name) {
        Connection conn= DButil.getConnection();

        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from EMPLOYEE where EMP_NAME=?",name);

        ResultSet rs=DButil.query(pstmt);

        try {
            while (rs.next()){
                return new EMPLOYEE(rs.getInt("Id"),
                rs.getInt("POST_TYPR"),
                        rs.getString("EMP_NAME"),
                        rs.getInt("EMP_SEX"),
                        rs.getInt("EMP_AGE"),
                        rs.getString("EMP_DEPART"),
                        rs.getInt("EMP_YEAR"));
            }
            return null;
        }catch  (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<EMPLOYEE> selectAll() {
        //调用Dbutil获取连接对象
        Connection conn=DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from EMPLOYEE");
        //执行查询语句
        ResultSet rs=DButil.query(pstmt);
        //准备集合
        List<EMPLOYEE> employees=new ArrayList<EMPLOYEE>();
        try{
            while (rs.next()){
                employees.add(new EMPLOYEE(rs.getInt("Id"),
                        rs.getInt("POST_TYPR"),
                        rs.getString("EMP_NAME"),
                        rs.getInt("EMP_SEX"),
                        rs.getInt("EMP_AGE"),
                        rs.getString("EMP_DEPART"),
                        rs.getInt("EMP_YEAR")));
            }
            return employees;
        }catch(Exception e){
            return employees;
        }
    }
}
