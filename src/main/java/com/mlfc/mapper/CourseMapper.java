package com.mlfc.mapper;

import com.mlfc.entity.Course;
import com.mlfc.entity.CourseCount;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from public_timetable")
    List<Course> list();

    @Insert("insert into personal_timeTable (course_id, course_name, teacher_name, classroom, week, time, user_id) " +
            "values (#{course.courseId}, #{course.courseName}, #{course.teacherName}, #{course.classroom}, #{course.week}, #{course.time}, #{user_id})")
    void reserveCourse(@Param("course") Course course, @Param("user_id") Integer user_id);


    @Update("update public_timetable set booked = booked + 1 where id = #{courseId}")
    void updateBooked(Integer courseId);

    @Select("SELECT IFNULL(COUNT(*), 0) FROM personal_timeTable WHERE course_id = #{courseId} AND user_id = #{userId}")
    Boolean isReserved(@Param("courseId") Integer courseId, @Param("userId") Integer userId);

    @Select("select * from personal_timetable where user_id = #{userId}")
    List<Course> myCourse(Integer userId);

    @Select("select IFNULL(COUNT(*), 0) from personal_timetable where user_id = #{userId}")
    int getReservedCourseCount(Integer userId);

    @Select("SELECT course_name, COUNT(*) as course_count FROM personal_timetable WHERE user_id = #{userId} GROUP BY course_name")
    List<CourseCount> myCourseCount(Integer userId);

    @Select("SELECT name, SUM(booked) as course_count FROM public_timetable GROUP BY name ORDER BY course_count ")
    List<CourseCount> CourseCount();

    @Insert("insert into public_timetable (name, teacher_name, classroom, week, time, total, booked,teacher_id) " +
            "values (#{name}, #{teacherName}, #{classroom}, #{week}, #{time}, #{total}, 0, #{teacherId})")
    void addCourse(Course course);

    void delete(@Param("ids") long[] ids);

}
