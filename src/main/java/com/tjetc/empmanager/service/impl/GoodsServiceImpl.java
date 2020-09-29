package com.tjetc.empmanager.service.impl;

import com.tjetc.empmanager.dao.GoodsDao;
import com.tjetc.empmanager.dao.impl.GoodsDaoImpl;
import com.tjetc.empmanager.domain.Goods;
import com.tjetc.empmanager.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao;

    public GoodsServiceImpl() {
        this.dao = new GoodsDaoImpl();
    }

    @Override
    public String addGoods(Goods g) {
        return this.dao.insert(g)>0?"添加成功":"添加失败";
    }

    @Override
    public List<Goods> findAll() {
        return this.dao.selectAll();
    }
}
