package com.mlfc.controller;

import com.mlfc.common.Rest;
import com.mlfc.entity.Bill;
import com.mlfc.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/list")
    public Rest<List<Bill>> list() {
        List<Bill> list = billService.list();
        log.info("账单列表:{}", list);
        return Rest.success(list);
    }
}
