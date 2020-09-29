package com.tjetc.empmanager.service.impl;

import com.tjetc.empmanager.dao.EMPLOYEEDao;
import com.tjetc.empmanager.dao.impl.EMPLOYEEDaoImpl;
import com.tjetc.empmanager.domain.EMPLOYEE;
import com.tjetc.empmanager.service.EMPLOYEEService;

import java.util.List;

public class EMPLOYEEServiceImpl implements EMPLOYEEService {


    private EMPLOYEEDao dao;

    public EMPLOYEEServiceImpl(){
        this.dao=new EMPLOYEEDaoImpl();
    }
    @Override
    public EMPLOYEE findByName(String name) {
        return this.dao.selectByName(name);
    }

    @Override
    public List<EMPLOYEE> finAll() {

        return this.dao.selectAll();
    }
}
