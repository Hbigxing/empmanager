package com.tjetc.empmanager.dao;

import com.tjetc.empmanager.domain.EMPLOYEE;

import java.util.List;

public interface EMPLOYEEDao {
    EMPLOYEE selectByName(String name);
    List<EMPLOYEE> selectAll();
}
