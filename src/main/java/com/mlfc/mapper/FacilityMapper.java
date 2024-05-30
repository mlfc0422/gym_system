package com.mlfc.mapper;

import com.mlfc.entity.Facility;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FacilityMapper {
    //查询健身器材列表
    @Select("SELECT * FROM facility")
    List<Facility> facilityList();

    //删除某健身器材
    void delete(@Param("ids") long[] ids);

    @Insert("INSERT INTO facility(name,num,root_id,text,create_time,update_time) VALUES(#{name},#{num},#{rootId},#{text},#{createTime},#{updateTime})")
    void insertFacility(Facility facility);

    @Update("UPDATE facility SET name=#{name},num=#{num},root_id=#{rootId},text=#{text},update_time=#{updateTime} WHERE id=#{id}")
    void updateFacility(Facility facility);
}
