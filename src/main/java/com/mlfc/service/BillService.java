package com.mlfc.service;

import com.mlfc.entity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> list();

    void addBill(Bill bill, int root_id);

    void updateBill(Bill bill);
}
