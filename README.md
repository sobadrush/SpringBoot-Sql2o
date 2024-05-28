# SpringBoot-Sql2o

## 簡介
這是一個使用 Spring Boot 框架的範例專案，專案中使用了 Sql2o 來操作資料庫。

## 1. 使用 Docker 啟動 SQL Server
```bash
docker run -d \
    -e "ACCEPT_EULA=Y" \
    -e "MSSQL_SA_PASSWORD=Ver7CompleXPW" \
    -p 1433:1433 \
    --name roger-mssql \
    mcr.microsoft.com/azure-sql-edge:latest
```

## 2. 建立資料庫
> 執行 「相關檔案/initial_Database.db」初始化 DB


## 3. 導入 Sql2o
```xml
<dependency>
    <groupId>org.sql2o</groupId>
    <artifactId>sql2o</artifactId>
    <version>1.6.0</version>
</dependency>
```

### 參考資料
- [Sql2o](https://www.sql2o.org/)
- [Spring 中使用 Sql2O](https://medium.com/skyler-record/spring-中使用-sql2o-e7114de56dba)