package com.mlfc.service;

import com.mlfc.common.MyCustomException;
import com.mlfc.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> list();

    void reserveCourse(Course course, Integer user_id) throws MyCustomException;
}
