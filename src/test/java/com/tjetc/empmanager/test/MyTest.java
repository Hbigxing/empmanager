package com.tjetc.empmanager.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjetc.empmanager.dao.DeptDao;
import com.tjetc.empmanager.dao.EMPLOYEEDao;
import com.tjetc.empmanager.dao.impl.DeptDaoImpl;
import com.tjetc.empmanager.dao.impl.EMPLOYEEDaoImpl;
import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.domain.EMPLOYEE;
import com.tjetc.empmanager.service.EMPLOYEEService;
import com.tjetc.empmanager.service.impl.EMPLOYEEServiceImpl;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
       DeptDao deptDao=new DeptDaoImpl();
        /* System.out.println(deptDao.selectByLikeName("A"));*/
        /*int i = deptDao.update(new Dept(20,"RESEARCH","天津"));
        System.out.println(i);*/
        List<Dept> depts=deptDao.selectAll();







        //EMPLOYEEDao employeeDao=new EMPLOYEEDaoImpl();
        /*System.out.println(employeeDao.selectById(4));*/
        //List<EMPLOYEE> employees=employeeDao.selectAll();
        String s= JSON.toJSONString(depts, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        System.out.println(s);


        //EMPLOYEEService employeeService=new EMPLOYEEServiceImpl();
        //System.out.println(employeeService.finAll());

    }
}
