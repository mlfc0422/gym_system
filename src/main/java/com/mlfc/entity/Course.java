package com.mlfc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    private Integer id;
    private String name;
    private String week;
    private Time time;
    private String classroom;
    private String teacherName;
    private Integer booked;
    private Integer total;
    private Integer teacherId;
}
