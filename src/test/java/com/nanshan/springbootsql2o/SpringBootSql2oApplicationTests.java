package com.nanshan.springbootsql2o;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootSql2oApplicationTests {

    @Test
    @Disabled
    @DisplayName("Test001: 我是 Test001")
    void test_001(TestInfo testInfo) {
        System.out.println("Test: " + testInfo.getDisplayName());
    }

}
