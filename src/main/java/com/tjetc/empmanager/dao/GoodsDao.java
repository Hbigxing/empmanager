package com.tjetc.empmanager.dao;

import com.tjetc.empmanager.domain.Goods;

import java.util.List;

public interface GoodsDao {
    int insert(Goods g);
    List<Goods> selectAll();
}
