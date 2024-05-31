package com.mlfc.service.Impl;

import com.mlfc.common.MyCustomException;
import com.mlfc.entity.Course;
import com.mlfc.entity.CourseCount;
import com.mlfc.mapper.CourseMapper;
import com.mlfc.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> list() {
        return courseMapper.list();
    }

    @Override
    public void reserveCourse(Course course, Integer user_id) throws MyCustomException {
        if (Objects.equals(course.getBooked(), course.getTotal())) {
            throw new MyCustomException("课程已满");
        }
        log.info("已过课程满员判断");
        //判断是否已经预约
        if (courseMapper.isReserved(course.getId(), user_id)) {
            throw new MyCustomException("已经预约过该课程");
        }
        log.info("已过预约判断");
        int reservedCount = courseMapper.getReservedCourseCount(user_id);
        if (reservedCount > 10) {
            throw new MyCustomException("已达最多可预约课程数");
        }
        courseMapper.reserveCourse(course, user_id);
        log.info("更新课程预约人数");
        courseMapper.updateBooked(course.getId());
    }

    @Override
    public List<Course> myCourse(Integer userId) {
        return courseMapper.myCourse(userId);
    }

    @Override
    public List<CourseCount> myCourseCount(Integer userId) {
        return courseMapper.myCourseCount(userId);
    }

    @Override
    public List<CourseCount> CourseCount() {
        return courseMapper.CourseCount();
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteCourse(long[] ids) {
        courseMapper.delete(ids);
    }


}
