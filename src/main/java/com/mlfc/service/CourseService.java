package com.mlfc.service;

import com.mlfc.common.MyCustomException;
import com.mlfc.entity.Course;
import com.mlfc.entity.CourseCount;

import java.util.List;

public interface CourseService {
    List<Course> list();

    void reserveCourse(Course course, Integer user_id) throws MyCustomException;

    List<Course> myCourse(Integer userId);

    List<CourseCount> myCourseCount(Integer userId);
}
