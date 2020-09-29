package com.tjetc.empmanager.service.impl;

import com.tjetc.empmanager.dao.DeptDao;
import com.tjetc.empmanager.dao.impl.DeptDaoImpl;
import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {
   private DeptDao dao;

   public DeptServiceImpl(){
       this.dao=new DeptDaoImpl();
   }

    @Override
    public String addDept(String id, String name, String loc) {
       try{
           int deptno=Integer.valueOf(id);
           if (this.dao.selectById(Integer.valueOf(id))!=null) return "id已存在，无法注册";
           if (this.dao.selectByName(name)!=null) return "name已存在，无法注册";
           return this.dao.insert(new Dept(deptno,name,loc))>0?"添加成功！":"添加失败！";
       }catch(Exception e){
           return "编号格式不正确";
       }
    }

    @Override
    public String deleteDept(String id) {
        return this.dao.delete(Integer.valueOf(id))>0?"删除成功":"删除失败";
    }

    @Override
    public String updateDept(String id, String name, String loc) {
        return this.dao.update(new Dept(Integer.valueOf(id),name,loc))>0?"修改成功":"修改失败";
    }

    @Override
    public List<Dept> findAll() {
        return this.dao.selectAll();
    }

    @Override
    public Dept findById(String id) {
        return this.dao.selectById(Integer.valueOf(id));
    }

    @Override
    public Dept findByName(String name) {
        return this.dao.selectByName(name);
    }

    @Override
    public List<Dept> findByLikeName(String name) {
        return this.dao.selectByLikeName(name);
    }
}
