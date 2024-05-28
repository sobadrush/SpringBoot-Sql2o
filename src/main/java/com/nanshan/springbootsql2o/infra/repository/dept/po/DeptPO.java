package com.nanshan.springbootsql2o.infra.repository.dept.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptPO {

    private Integer deptId;
    private String deptName;
    private String location;

}
