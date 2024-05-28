package com.mlfc.controller;

import com.mlfc.common.MyCustomException;
import com.mlfc.common.Rest;
import com.mlfc.entity.Course;
import com.mlfc.entity.CourseCount;
import com.mlfc.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public Rest<List<Course>> list() {
        List<Course> list = courseService.list();
        log.info("课程列表:{}", list);
        return Rest.success(list);
    }

    @PutMapping("/reserve")
    public Rest<String> reserveCourse(@RequestBody Course course, HttpServletRequest request) throws MyCustomException {
        log.info("预约课程:{}", course);
        Integer user_id = (int) request.getSession().getAttribute("user");
        log.info("用户id:{}", user_id);
        courseService.reserveCourse(course, user_id);
        return Rest.success("预约成功");
    }

    @GetMapping("/myCourse")
    public Rest<List<Course>> myCourse(HttpServletRequest request) {
        Integer user_id = (int) request.getSession().getAttribute("user");
        List<Course> list = courseService.myCourse(user_id);
        log.info("我的课程:{}", list);
        return Rest.success(list);
    }

    @GetMapping("/myCourseCount")
    public Rest<List<CourseCount>> myCourseCount(HttpServletRequest request) {
        Integer user_id = (int) request.getSession().getAttribute("user");
        List<CourseCount> list = courseService.myCourseCount(user_id);
        log.info("我的课程统计:{}", list);
        return Rest.success(list);
    }

    @GetMapping("/courseCountList")
    public Rest<List<CourseCount>> courseCountList() {
        List<CourseCount> list = courseService.CourseCount();
        log.info("课程统计:{}", list);
        return Rest.success(list);
    }


}
