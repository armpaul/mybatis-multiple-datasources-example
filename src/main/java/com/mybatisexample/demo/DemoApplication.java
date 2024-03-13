package com.mybatisexample.demo;

import com.mybatisexample.demo.domain.TestCase1Run;
import com.mybatisexample.demo.domain.TestCaseRun;
import com.mybatisexample.demo.domain.TestDataSource;
import com.mybatisexample.demo.mapper.mysql.TestDataSourceRunMapper;
import com.mybatisexample.demo.mapper.postgres1.TestCase1RunMapper;
import com.mybatisexample.demo.mapper.postgres.TestCaseRunMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final TestCaseRunMapper testCaseRunMapper;
	private final TestCase1RunMapper testCase1RunMapper;
	private final TestDataSourceRunMapper testDataSourceRunMapper;
//	private final TestLaunchMapper testLaunchMapper;

	public DemoApplication(
			TestCaseRunMapper testCaseRunMapper,
			TestCase1RunMapper testCase1RunMapper,
			TestDataSourceRunMapper testDataSourceRunMapper
//			TestLaunchMapper testLaunchMapper
	) {
		this.testCaseRunMapper = testCaseRunMapper;
		this.testCase1RunMapper = testCase1RunMapper;
		this.testDataSourceRunMapper = testDataSourceRunMapper;
//		this.testLaunchMapper = testLaunchMapper;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<TestCaseRun> testCaseRuns = this.testCaseRunMapper.findAll();
		System.out.println(testCaseRuns.get(0).getStartDate());

		List<TestCase1Run> testCase1Runs = this.testCase1RunMapper.findAll();
		System.out.println(testCase1Runs.get(0).getStartDate());

		List<TestDataSource> testDataSourceRuns = this.testDataSourceRunMapper.findAll();
		System.out.println(testDataSourceRuns.get(0).getDescription());

//		List<TestLaunch> testLaunches = testLaunchMapper.findAll();
//		System.out.println(testLaunches);

		System.out.println("Hello");
	}
}
