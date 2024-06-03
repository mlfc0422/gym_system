package com.mlfc.service;

import com.mlfc.entity.Emp;

import java.util.List;

public interface EmpService {
    void addEmp(Emp emp);

    List<Emp> list();

    void update(Emp emp);

    void deleteEmpById(int[] ids);
}
