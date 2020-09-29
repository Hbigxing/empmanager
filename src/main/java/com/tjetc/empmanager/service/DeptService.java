package com.tjetc.empmanager.service;

import com.tjetc.empmanager.domain.Dept;

import java.util.List;

public interface DeptService {
    //增加部门
    String addDept(String id,String name,String loc);
    //删除部门
    String deleteDept(String id);
    //修改部门
    String updateDept(String id,String name,String loc);
    //查询全部部门
    List<Dept> findAll();
    //根据ID查询部门
    Dept findById(String id);
    Dept findByName(String name);
    List<Dept> findByLikeName(String name);
}
