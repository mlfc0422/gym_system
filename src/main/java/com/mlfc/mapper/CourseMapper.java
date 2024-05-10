package com.mlfc.mapper;

import com.mlfc.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from public_timetable")
    List<Course> list();

    @Insert("insert into personal_timeTable (course_id, course_name, teacher_name, classroom, week, time, user_id) " +
            "values (#{course.courseId}, #{course.courseName}, #{course.teacherName}, #{course.classroom}, #{course.week}, #{course.time}, #{user_id})")
    void reserveCourse(@Param("course") Course course, @Param("user_id") Integer user_id);



    @Update("update public_timetable set booked = booked + 1 where course_id = #{courseId}")
    void updateBooked(Integer courseId);

    @Select("SELECT IFNULL(COUNT(*), 0) FROM personal_timeTable WHERE course_id = #{courseId} AND user_id = #{userId}")
    Boolean isReserved(@Param("courseId") Integer courseId, @Param("userId") Integer userId);

}
