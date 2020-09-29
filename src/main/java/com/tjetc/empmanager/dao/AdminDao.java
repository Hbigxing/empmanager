package com.tjetc.empmanager.dao;

import com.tjetc.empmanager.domain.Admin;

public interface AdminDao {
    Admin selectByNameAndPassword(String account,String password);
}
