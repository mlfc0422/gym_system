package com.mlfc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String name;
    private String post;
    private String phone;
    private Integer age;
    private LocalDateTime createTime;
    private Double salary;
    private LocalDateTime updateTime;
}
