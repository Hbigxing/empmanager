package com.tjetc.empmanager.dao.impl;

import com.tjetc.empmanager.dao.AdminDao;
import com.tjetc.empmanager.domain.Admin;
import com.tjetc.empmanager.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin selectByNameAndPassword(String account, String password) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn, "select * from user where account=? and password=?", account, password);
        ResultSet rs = DButil.query(pstmt);
        try {
            if(rs.next()){
                return new Admin(rs.getInt("id"),
                        rs.getString("account"),
                        rs.getString("password"),
                        rs.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DButil.close(conn,pstmt,rs);
        }


    }
}
