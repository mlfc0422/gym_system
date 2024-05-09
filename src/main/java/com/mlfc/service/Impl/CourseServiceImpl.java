package com.mlfc.service.Impl;

import com.mlfc.entity.Course;
import com.mlfc.entity.User;
import com.mlfc.mapper.CourseMapper;
import com.mlfc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> list() {
        return courseMapper.list();
    }
}
