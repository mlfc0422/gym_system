package com.mlfc.controller;

import com.mlfc.common.MyCustomException;
import com.mlfc.common.Rest;
import com.mlfc.dto.CourseCountDTO;
import com.mlfc.dto.TimeCountDTO;
import com.mlfc.entity.Course;
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

    @PostMapping("/reserve")
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
    public Rest<List<CourseCountDTO>> myCourseCount(HttpServletRequest request) {
        Integer user_id = (int) request.getSession().getAttribute("user");
        List<CourseCountDTO> list = courseService.myCourseCount(user_id);
        log.info("我的课程统计:{}", list);
        return Rest.success(list);
    }

    @GetMapping("/courseCountList")
    public Rest<List<CourseCountDTO>> courseCountList() {
        List<CourseCountDTO> list = courseService.CourseCount();
        log.info("课程统计:{}", list);
        return Rest.success(list);
    }

    // 添加课程
    @PostMapping()
    public Rest<String> addCourse(@RequestBody Course course) throws MyCustomException {
        log.info("添加课程:{}", course);
        courseService.addCourse(course);
        return Rest.success("添加课程成功");
    }

    @PutMapping()
    public Rest<String> updateCourse(@RequestBody Course course) throws MyCustomException {
        log.info("更新课程:{}", course);
        courseService.updateCourse(course);
        return Rest.success("更新课程成功");
    }

    @DeleteMapping()
    public Rest<String> deleteCourse(@RequestBody long[] ids) {
        log.info("删除课程:{}", ids);
        courseService.deleteCourse(ids);
        return Rest.success("删除课程成功");
    }

    @DeleteMapping("/clear")
    public Rest<String> clear() {
        courseService.clear();
        return Rest.success("重置成功");
    }

    @GetMapping("/timeCount")
    public Rest<List<TimeCountDTO>> timeCount() {
        List<TimeCountDTO> list = courseService.timeCount();
        log.info("时间统计:{}", list);
        return Rest.success(list);
    }
}
