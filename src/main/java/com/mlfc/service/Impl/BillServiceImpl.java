package com.mlfc.service.Impl;

import com.mlfc.entity.Bill;
import com.mlfc.mapper.BillMapper;
import com.mlfc.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    public List<Bill> list() {
        return billMapper.list();
    }

}
