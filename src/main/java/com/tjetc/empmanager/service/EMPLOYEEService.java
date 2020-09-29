package com.tjetc.empmanager.service;

import com.tjetc.empmanager.domain.EMPLOYEE;

import java.util.List;

public interface EMPLOYEEService {
    EMPLOYEE findByName(String name);

    List<EMPLOYEE> finAll();
}
