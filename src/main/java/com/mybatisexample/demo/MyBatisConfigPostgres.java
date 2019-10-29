package com.mybatisexample.demo;

import com.mybatisexample.demo.mapper.postgres.TestCaseRunMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.mybatisexample.demo.mapper.postgres", sqlSessionFactoryRef="sqlSessionPostgres")
public class MyBatisConfigPostgres {

    @Bean(name = "dataSourcePostgres")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
        dataSourceBuilder.username("username");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }

    @Bean(name = "sqlSessionPostgres")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

//    @Bean
//    public TestCaseRunMapper testCaseRunMapper1() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//        return sqlSessionTemplate.getMapper(TestCaseRunMapper.class);
//    }

//    @Bean
//    public TestLaunchMapper testLaunchMapper1() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//        return sqlSessionTemplate.getMapper(TestLaunchMapper.class);
//    }

//    @Bean
//    public MapperFactoryBean<TestLaunchMapper> testLaunchMapper() throws Exception {
//        MapperFactoryBean<TestLaunchMapper> factoryBean = new MapperFactoryBean<>(TestLaunchMapper.class);
//        factoryBean.setSqlSessionFactory(sqlSessionFactory());
//        return factoryBean;
//    }

//    @Bean
//    public MapperScannerConfigurer testLaunchMapper() throws Exception {
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setBasePackage("com.mybatisexample.demo.mapper.clickhouse.TestLaunchMapper");
//        configurer.setSqlSessionFactory(sqlSessionFactory());
//        return configurer;
//    }
}
