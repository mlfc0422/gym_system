package com.mlfc.service.Impl;

import com.mlfc.entity.Facility;
import com.mlfc.mapper.FacilityMapper;
import com.mlfc.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityMapper facilityMapper;

    @Override
    public List<Facility> facilityList() {
        return facilityMapper.facilityList();
    }

    @Override
    public void insertFacility(Facility facility, int root_id) {
        facility.setCreateTime(LocalDateTime.now());
        facility.setUpdateTime(LocalDateTime.now());
        facility.setRootId(root_id);
        facilityMapper.insertFacility(facility);
    }

    @Override
    public void updateFacility(Facility facility, int root_id) {
        facility.setUpdateTime(LocalDateTime.now());
        facility.setRootId(root_id);
        facilityMapper.updateFacility(facility);
    }

    @Override
    public void delete(long[] ids) {
        facilityMapper.delete(ids);
    }
}
