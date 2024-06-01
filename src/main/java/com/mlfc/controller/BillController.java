package com.mlfc.controller;

import com.mlfc.common.Rest;
import com.mlfc.entity.Bill;
import com.mlfc.service.BillService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public Rest<String> addBill(@RequestBody Bill bill, HttpServletRequest request) {
        int root_id = (int) request.getSession().getAttribute("root");
        billService.addBill(bill, root_id);
        log.info("新增账单:{}", bill);
        return Rest.success("新增成功");
    }

    @PutMapping()
    public Rest<String> updateBill(@RequestBody Bill bill) {
        billService.updateBill(bill);
        return Rest.success("修改成功");
    }
}
