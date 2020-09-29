package com.tjetc.empmanager.service;

import com.tjetc.empmanager.domain.Goods;

import java.util.List;

public interface GoodsService {
    String addGoods(Goods g);
    List<Goods> findAll();
}
