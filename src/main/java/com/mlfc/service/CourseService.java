package com.mlfc.service;

import com.mlfc.common.MyCustomException;
import com.mlfc.dto.CourseCountDTO;
import com.mlfc.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> list();

    void reserveCourse(Course course, Integer user_id) throws MyCustomException;

    List<Course> myCourse(Integer userId);

    List<CourseCountDTO> myCourseCount(Integer userId);

    List<CourseCountDTO> CourseCount();

    void addCourse(Course course) throws MyCustomException;

    void deleteCourse(long[] ids);

    void updateCourse(Course course) throws MyCustomException;

    void clear();


}
