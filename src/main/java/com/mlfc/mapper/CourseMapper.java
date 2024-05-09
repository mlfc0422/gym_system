package com.mlfc.mapper;

import com.mlfc.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from public_timetable")
    List<Course> list();

}
