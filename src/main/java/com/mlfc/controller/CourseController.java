package com.mlfc.controller;

import com.mlfc.common.Rest;
import com.mlfc.entity.Course;
import com.mlfc.entity.User;
import com.mlfc.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
