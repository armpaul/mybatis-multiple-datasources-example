package com.mybatisexample.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.mybatisexample.demo.mapper.postgres1", sqlSessionFactoryRef="sqlSessionPostgres1")
public class MyBatisConfigPostgres1 {

    @Bean(name = "dataSourcePostgres1")
    public DataSource dataSourcePostgres1() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres1");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("12345678");
        return dataSourceBuilder.build();
    }

    @Bean(name = "sqlSessionPostgres1")
    public SqlSessionFactory sqlSessionFactoryPostgres1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourcePostgres1());
        return factoryBean.getObject();
    }
}
