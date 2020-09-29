package com.tjetc.empmanager.dao;

import com.tjetc.empmanager.domain.Emp;

import java.util.List;

public interface EmpDao {
   //增
    int insert(Emp emp);
    //删
    int delete(int id);
    //改
    int update(Emp emp);
    //查询所有
    List<Emp> selectAll();
    //id,name查询
    Emp selectByIdAndName(int empno,String ename);
    //查询所有部门经理
    List<Emp> selectManager();
    //id查询
    Emp selectById(int id);
}
