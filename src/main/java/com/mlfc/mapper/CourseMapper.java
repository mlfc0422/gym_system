package com.mlfc.mapper;

import com.mlfc.dto.CourseCountDTO;
import com.mlfc.dto.TimeCountDTO;
import com.mlfc.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from public_timetable")
    List<Course> list();

    @Insert("insert into personal_timetable (course_id, name, teacher_name, classroom, week, time, user_id) " +
            "values (#{course.id}, #{course.name}, #{course.teacherName}, #{course.classroom}, #{course.week}, #{course.time}, #{user_id})")
    void reserveCourse(@Param("course") Course course, @Param("user_id") Integer user_id);


    @Update("update public_timetable set booked = booked + 1 where id = #{courseId}")
    void updateBooked(Integer courseId);

    @Select("SELECT IFNULL(COUNT(*), 0) FROM personal_timeTable WHERE course_id = #{courseId} AND user_id = #{userId}")
    Boolean isReserved(@Param("courseId") Integer courseId, @Param("userId") Integer userId);

    @Select("select * from personal_timetable where user_id = #{userId}")
    List<Course> myCourse(Integer userId);

    @Select("select IFNULL(COUNT(*), 0) from personal_timetable where user_id = #{userId}")
    int getReservedCourseCount(Integer userId);

    @Select("SELECT name, COUNT(*) as course_count FROM personal_timetable WHERE user_id = #{userId} GROUP BY name")
    List<CourseCountDTO> myCourseCount(Integer userId);

    @Select("SELECT name, teacher_name, SUM(booked) as course_count FROM public_timetable GROUP BY name,teacher_name ORDER BY course_count DESC")
    List<CourseCountDTO> CourseCount();

    @Insert("insert into public_timetable (name, teacher_name, classroom, week, time, total, booked,teacher_id) " +
            "values (#{name}, #{teacherName}, #{classroom}, #{week}, #{time}, #{total}, 0, #{teacherId})")
    void addCourse(Course course);


    @Select("SELECT EXISTS(SELECT 1 FROM public_timetable WHERE week = #{week} AND time = #{time} AND teacher_id = #{teacherId})")
    boolean isCourseExistByTeacher(Course course);

    @Select("SELECT EXISTS(SELECT 1 FROM public_timetable WHERE week = #{week} AND time = #{time} AND classroom = #{classroom})")
    boolean isCourseExistByClassroom(Course course);

    @Select("SELECT teacher_name FROM public_timetable WHERE teacher_id = #{teacherId} limit 1")
    String getTeacherName(Integer teacherId);


    @Update("update public_timetable set name = #{name}, teacher_name = #{teacherName}, classroom = #{classroom}, week = #{week}, time = #{time}, total = #{total}, teacher_id = #{teacherId} where id = #{id}")
    void updatePublicCourse(Course course);

    @Update("update personal_timetable set name = #{name}, teacher_name = #{teacherName}, classroom = #{classroom}, week = #{week}, time = #{time} where course_id = #{id}")
    void updatePersonalCourse(Course course);


    void deletePublic(@Param("ids") long[] ids);

    void deletePersonal(@Param("ids") long[] ids);

    @Update("update public_timetable set booked = 0")
    void clearBooked();

    @Delete("delete from personal_timetable")
    void clearPersonal();

    @Select("SELECT time, SUM(booked) AS course_count FROM public_timetable GROUP BY time ORDER BY course_count DESC")
    List<TimeCountDTO> timeCount();


}
