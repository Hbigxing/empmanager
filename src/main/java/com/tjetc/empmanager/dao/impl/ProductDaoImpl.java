package com.tjetc.empmanager.dao.impl;

import com.tjetc.empmanager.dao.ProductDao;
import com.tjetc.empmanager.domain.Product;
import com.tjetc.empmanager.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product selectById(int id) {
        Connection conn =DButil.getConnection();
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from product where id=?",id);
        ResultSet rs=DButil.query(pstmt);
        try{
            while (rs.next()){
                return new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getInt("categoryLevel1Id"),
                        rs.getInt("categoryLevel2Id"),
                        rs.getInt("categoryLevel3Id"),
                        rs.getString("fileName"),
                        rs.getInt("isDelete"),
                        rs.getInt("brand_id"));
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> selectAll() {
        Connection conn =DButil.getConnection();
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from product");
        ResultSet rs=DButil.query(pstmt);
        List<Product> products=new ArrayList<Product>();
        try{
            while (rs.next()){
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getInt("categoryLevel1Id"),
                        rs.getInt("categoryLevel2Id"),
                        rs.getInt("categoryLevel3Id"),
                        rs.getString("fileName"),
                        rs.getInt("isDelete"),
                        rs.getInt("brand_id")));
            }
            return products;
        }catch (SQLException e){
            e.printStackTrace();
            return products;
        }
    }

    @Override
    public List<Product> selectByLikeName(String name) {
        Connection conn=DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DButil.getPstmt(conn,"select * from dept where dname like ?","%"+name+"%");
        //执行查询语句
        ResultSet rs=DButil.query(pstmt);
        //准备集合
        List<Product> products=new ArrayList<Product>();
        try{
            while (rs.next()){
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getInt("categoryLevel1Id"),
                        rs.getInt("categoryLevel2Id"),
                        rs.getInt("categoryLevel3Id"),
                        rs.getString("fileName"),
                        rs.getInt("isDelete"),
                        rs.getInt("brand_id")));
            }
            return products;
        }catch(Exception e){
            return products;
        }
    }
}
