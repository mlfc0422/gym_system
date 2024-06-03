package com.mlfc.mapper;

import com.mlfc.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Insert("insert into emp(name, post, phone, age, create_time, salary) values(#{name}, #{post}, #{phone}, #{age}, #{createTime}, #{salary})")
    void addEmp(Emp emp);


    @Select("select * from emp")
    List<Emp> list();

    @Update("update emp set name=#{name}, post=#{post}, phone=#{phone}, age=#{age}, salary=#{salary}, update_time=#{updateTime} where id=#{id}")
    void update(Emp emp);


    void deleteEmpById(@Param("ids") int[] ids);
}
