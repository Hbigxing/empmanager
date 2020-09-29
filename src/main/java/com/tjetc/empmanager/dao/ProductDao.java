package com.tjetc.empmanager.dao;

import com.tjetc.empmanager.domain.Product;

import java.util.List;

public interface ProductDao {
    Product selectById(int id);
    List<Product> selectAll();
    List<Product> selectByLikeName(String name);
}
