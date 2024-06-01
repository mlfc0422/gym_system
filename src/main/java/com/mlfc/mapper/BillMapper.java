package com.mlfc.mapper;

import com.mlfc.entity.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BillMapper {
    @Select("select * from finance")
    List<Bill> list();

    @Insert("insert into finance (amount, text,root_id,create_time,update_time) values ( #{amount}, #{text}, #{rootId}, #{createTime}, #{updateTime})")
    void addBill(Bill bill);

    @Update("update finance set text = #{text}, update_time = #{updateTime} where id = #{id}")
    void updateBill(Bill bill);
}
