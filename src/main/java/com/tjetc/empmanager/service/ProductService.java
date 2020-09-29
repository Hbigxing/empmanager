package com.tjetc.empmanager.service;

import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String id);
    List<Product> findByLikeName(String name);
}
