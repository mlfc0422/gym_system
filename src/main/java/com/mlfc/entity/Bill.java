package com.mlfc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bill {
    private Integer id;
    private Integer rootId;
    private BigInteger amount;
    private String text;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
