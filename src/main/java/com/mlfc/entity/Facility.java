package com.mlfc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Facility {
    private Integer id;
    private String name;
    private Integer num;
    private Integer rootId;
    private String text;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
