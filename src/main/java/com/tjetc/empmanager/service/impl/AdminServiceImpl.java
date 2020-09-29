package com.tjetc.empmanager.service.impl;

import com.tjetc.empmanager.dao.AdminDao;
import com.tjetc.empmanager.dao.impl.AdminDaoImpl;
import com.tjetc.empmanager.domain.Admin;
import com.tjetc.empmanager.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao;

    public AdminServiceImpl() {
        this.dao =new AdminDaoImpl();
    }

    @Override
    public Admin login(String account, String password) {
        return this.dao.selectByNameAndPassword(account,password);
    }
}
