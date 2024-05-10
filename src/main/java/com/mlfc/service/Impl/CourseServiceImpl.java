package com.mlfc.service.Impl;

import com.mlfc.common.MyCustomException;
import com.mlfc.entity.Course;
import com.mlfc.mapper.CourseMapper;
import com.mlfc.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> list() {
        return courseMapper.list();
    }

    @Override
    public void reserveCourse(Course course, Integer user_id) throws MyCustomException {
        if (Objects.equals(course.getBooked(), course.getTotal())){
            throw new MyCustomException("课程已满");
        }
        log.info("已过课程满员判断");
        //判断是否已经预约
        if (courseMapper.isReserved(course.getCourseId(), user_id)){
            throw new MyCustomException("已经预约过该课程");
        }
        log.info("已过预约判断");
        courseMapper.reserveCourse(course, user_id);
        log.info("更新课程预约人数");
        courseMapper.updateBooked(course.getCourseId());
    }
}
