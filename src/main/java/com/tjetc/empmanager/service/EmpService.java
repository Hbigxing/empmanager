package com.tjetc.empmanager.service;

import com.tjetc.empmanager.domain.Emp;

import java.util.List;

public interface EmpService {
    String addEmp(Emp emp);

    List<Emp> findAll();

    List<Emp> findAllManager();

    Emp findById(String id);

    String changEmp(Emp emp);

    String removeEmp(int id);
}
