package com.nanshan.springbootsql2o.infra.repository.dept;

import com.nanshan.springbootsql2o.infra.repository.DeptRepository;
import com.nanshan.springbootsql2o.infra.repository.dept.po.DeptPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class DeptRepositoryImpl implements DeptRepository {

    private final Sql2o sql2o;
    private Map<String, String> columnMappings;

    public DeptRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    /**
     *  不建議使用！！！
     *  這樣定義是 Global 的
     */
    // @PostConstruct
    // public void init() {
    //     log.info("DeptRepositoryImpl.init()");
    //     columnMappings = Map.of(
    //         "DEPTNO", "deptId",
    //         "DNAME", "deptName", "LOC",
    //         "location"
    //     );
    //     sql2o.setDefaultColumnMappings(columnMappings);
    // }

    @Override
    public List<DeptPO> selectAllDept() {
        String sql = "SELECT * FROM DEPT_TB";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addColumnMapping("DEPTNO", "deptId")
                    .addColumnMapping("DNAME", "deptName")
                    .addColumnMapping("LOC", "location")
                    .executeAndFetch(DeptPO.class);
        }
    }

    @Override
    public DeptPO selectDept(Integer id) {
        String sql = "SELECT * FROM DEPT_TB WHERE DEPTNO = :deptId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("deptId", id)
                    .addColumnMapping("DEPTNO", "deptId")
                    .addColumnMapping("DNAME", "deptName")
                    .addColumnMapping("LOC", "location")
                    .executeAndFetchFirst(DeptPO.class);
        }
    }

}
