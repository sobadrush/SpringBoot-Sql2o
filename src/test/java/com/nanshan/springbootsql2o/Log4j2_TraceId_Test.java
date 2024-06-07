package com.nanshan.springbootsql2o;

import com.nanshan.springbootsql2o.infra.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.text.MessageFormat;

@SpringBootTest
// @ActiveProfiles("nanshan_macbook")
@ActiveProfiles("roger_macbook")
public class Log4j2_TraceId_Test {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        ThreadContext.put("traceId", Utils.getBase58Code());
        logger.info(MessageFormat.format(" ====== @BeforeEach setUp() - traceId: {0} ====== ", ThreadContext.get("traceId")));
    }

    @AfterEach
    void tearDown() {
        logger.info(" ====== @AfterEach tearDown()  ====== ");
        ThreadContext.remove("traceId");
    }

    @Test
    @DisplayName("Test001: 測試 Log4j2 的 ThreadContext 設定")
    void test_001(TestInfo testInfo) {
        System.err.println(" >>> 我是: " + testInfo.getDisplayName());
    }
}
