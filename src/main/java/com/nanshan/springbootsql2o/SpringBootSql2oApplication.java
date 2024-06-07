package com.nanshan.springbootsql2o;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class SpringBootSql2oApplication implements ApplicationListener<ApplicationReadyEvent>  {

    private static final Logger logger
            = LogManager.getLogger(SpringBootSql2oApplication.class.getName());

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "roger_macbook");
        SpringApplication.run(SpringBootSql2oApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ThreadContext.put("testKey", "AAA");
        logger.info(">>> 我是 onApplicationEvent() - 111 <<<");

        ThreadContext.put("testKey", "BBB");
        logger.info(">>> 我是 onApplicationEvent() - 222 <<<");

        ThreadContext.clearAll();
        logger.info(">>> 我是 onApplicationEvent() - 333 <<<");
    }
}
