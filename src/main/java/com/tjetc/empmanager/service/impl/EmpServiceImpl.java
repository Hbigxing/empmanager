package com.tjetc.empmanager.service.impl;

import com.tjetc.empmanager.dao.EmpDao;
import com.tjetc.empmanager.dao.impl.EmpDaoImpl;
import com.tjetc.empmanager.domain.Emp;
import com.tjetc.empmanager.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    public EmpServiceImpl(){
        this.empDao=new EmpDaoImpl();
    }

    @Override
    public String addEmp(Emp emp) {
       if(this.empDao.selectByIdAndName(emp.getEmpno(),emp.getEname())!=null){
           return "该员工已存在，录入失败";
       }
       return this.empDao.insert(emp)>0?"录入成功":"录入失败";
    }

    @Override
    public List<Emp> findAll() {
        return this.empDao.selectAll();
    }

    @Override
    public List<Emp> findAllManager() {
        return this.empDao.selectManager();
    }

    @Override
    public Emp findById(String id) {
        return this.empDao.selectById(Integer.valueOf(id));
    }

    @Override
    public String changEmp(Emp emp) {
        return this.empDao.update(emp)>0?"更新成功":"更新失败";
    }

    @Override
    public String removeEmp(int id) {
        return this.empDao.delete(id)>0?"删除成功":"删除失败";
    }
}
