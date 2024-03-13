package com.mybatisexample.demo.mapper.postgres1;

import com.mybatisexample.demo.domain.TestCase1Run;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestCase1RunMapper {
    @Select("SELECT * FROM stat_test_case_run limit 20")
    @Results({
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "testKey", column = "test_key"),
            @Result(property = "userKey", column = "user_key"),
            @Result(property = "testRunKey", column = "run_key"),
            @Result(property = "testPlanKey", column = "test_plan_key"),
    })
    List<TestCase1Run> findAll();
}
