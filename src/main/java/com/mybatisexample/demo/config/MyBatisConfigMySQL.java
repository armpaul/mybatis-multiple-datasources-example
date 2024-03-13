package com.mybatisexample.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.mybatisexample.demo.mapper.mysql", sqlSessionFactoryRef="sqlSessionMySQL")
public class MyBatisConfigMySQL {

    @Bean(name = "dataSourceMySQL")
    public DataSource dataSourceMySQL() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost/my_system_");
        dataSourceBuilder.username("mybatis");
        dataSourceBuilder.password("12345678");
        return dataSourceBuilder.build();
    }

    @Bean(name = "sqlSessionMySQL")
    public SqlSessionFactory sqlSessionFactoryMySQL() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceMySQL());
        return factoryBean.getObject();
    }
}
