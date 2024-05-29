package com.mlfc.mapper;

import com.mlfc.entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BillMapper {
    @Select("select * from finance")
    List<Bill> list();
}
