package com.nanshan.springbootsql2o;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Slf4j
public class RootConfig {

    @Bean(name = "dataSource")
    @Profile("nanshan_macbook")
    public DataSource dataSource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;database=DB_EMP_DEPT" + "trustServerCertificate=true");
        dataSource.setUsername("sa");
        dataSource.setPassword("Ver7CompleXPW");
        return dataSource;
    }

    @Bean(name = "dataSource")
    @Profile("roger_macbook")
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1437;database=DB_EMP_DEPT" + ";trustServerCertificate=true");
        dataSource.setUsername("sa");
        dataSource.setPassword("Ver7CompleXPW");
        return dataSource;
    }

    @Bean(name = "myTxManager")
    @Profile("nanshan_macbook")
    public PlatformTransactionManager transactionManager1(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean(name = "myTxManager")
    @Profile("roger_macbook")
    public PlatformTransactionManager transactionManager2(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    public Sql2o sql2o(DataSource ds) {
        log.info(" === Creating Sql2o Bean === ");
        return new Sql2o(ds);
    }
}