package com.mybatisexample.demo.mapper.mysql;

import com.mybatisexample.demo.domain.TestDataSource;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestDataSourceRunMapper {

    @Select("SELECT * FROM product limit 15")
    List<TestDataSource> findAll();

}
