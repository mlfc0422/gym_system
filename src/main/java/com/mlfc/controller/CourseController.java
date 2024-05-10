package com.mlfc.controller;

import com.mlfc.common.MyCustomException;
import com.mlfc.common.Rest;
import com.mlfc.entity.Course;
import com.mlfc.entity.User;
import com.mlfc.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
        log.info("课程列表:{}",list);
        return Rest.success(list);
    }

    @PutMapping("/reserve")
    public Rest<String> reserveCourse(@RequestBody Course course, HttpServletRequest request) throws MyCustomException {
        log.info("预约课程:{}",course);
        Integer user_id = (int) request.getSession().getAttribute("user");
        log.info("用户id:{}",user_id);
        courseService.reserveCourse(course, user_id);
        return Rest.success("预约成功");
    }
}
