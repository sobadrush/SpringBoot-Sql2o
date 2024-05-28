package com.nanshan.springbootsql2o.infra.repository;

import com.nanshan.springbootsql2o.infra.repository.dept.po.DeptPO;

import java.util.List;

public interface DeptRepository {
    List<DeptPO> selectAllDept();
    DeptPO selectDept(Integer deptId);
    // void insertDept(String deptName, String location);
    // void updateDept(String deptName, String location, Integer deptId);
    // void deleteDept(Integer deptId);
    // void deleteAllDept();
}