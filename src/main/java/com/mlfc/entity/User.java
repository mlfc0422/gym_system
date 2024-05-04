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
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Integer height;
    private Integer weight;
    private Integer age;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
