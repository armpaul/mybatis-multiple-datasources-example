package com.mybatisexample.demo.domain;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * Модель таблицы запусков тестов за билдах
 */
public class TestDataSource implements Comparable {

    private int id;
    private String img_url;
    private String title;
    private String description;
    private int price;
    private String mealtype;

    public TestDataSource() {
    }

    public int getId() {
        return id;
    }

    public String getImg_url() {
        return img_url;}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getMealtype() {
        return mealtype;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TestLaunch testLaunch = (TestLaunch) o;
//        return prId == testLaunch.prId &&
//                jobId == testLaunch.jobId &&
//                Objects.equals(testId, testLaunch.testId) &&
//                Objects.equals(jobDate, testLaunch.jobDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(testId, prId, jobId, jobDate);
//    }

    @Override
    public int compareTo(Object o) {
        return this.id - ((TestDataSource) o).getId();
    }
}

