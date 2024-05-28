package com.nanshan.springbootsql2o.infra.repository.dept;

import com.nanshan.springbootsql2o.infra.repository.dept.po.DeptPO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeptRepositoryImpl_Test {

    @Autowired
    private DeptRepositoryImpl deptRepo;

    @Test
    @Disabled
    @DisplayName("Test001: 查詢所有「部門」(Dept) 資料")
    void test_001() {
        deptRepo.selectAllDept().stream().forEach(System.out::println);
    }

    @Test
    @Disabled
    @DisplayName("Test002: 查詢「部門」(Dept) 資料 by ID")
    void test_002() {
        DeptPO deptPO = deptRepo.selectDept(20);
        System.out.println("deptPO = " + deptPO);
    }

}