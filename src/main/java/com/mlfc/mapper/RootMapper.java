package com.mlfc.mapper;

import com.mlfc.entity.Root;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RootMapper {
    @Select("select id,username,password from root where username = #{username}")
    Root findByUsername(String username);
}
