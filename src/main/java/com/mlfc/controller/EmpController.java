package com.mlfc.controller;


import com.mlfc.common.Rest;
import com.mlfc.entity.Emp;
import com.mlfc.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    // 添加员工信息
    @PostMapping
    public Rest<String> addEmployee(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return Rest.success("员工信息添加成功");
    }

    @GetMapping("/list")
    public Rest<List<Emp>> list() {
        List<Emp> list = empService.list();
        return Rest.success(list);
    }

    @PutMapping
    public Rest<String> update(@RequestBody Emp emp) {
        empService.update(emp);
        return Rest.success("修改成功");
    }

    @DeleteMapping
    public Rest<String> deleteEmployeeById(@RequestBody int[] ids) {
        log.info("删除员工信息:{}", ids);
        empService.deleteEmpById(ids);
        return Rest.success("员工信息删除成功");
    }
}
