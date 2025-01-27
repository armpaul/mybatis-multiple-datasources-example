package com.mybatisexample.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.mybatisexample.demo.mapper.postgres", sqlSessionFactoryRef="sqlSessionPostgres")
public class MyBatisConfigPostgres {

    @Bean(name = "dataSourcePostgres")
    public DataSource dataSourcePostgres() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("12345678");
        return dataSourceBuilder.build();
    }

    @Bean(name = "sqlSessionPostgres")
    @Primary
    public SqlSessionFactory sqlSessionFactoryPostgres() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourcePostgres());
        return factoryBean.getObject();
    }
}
