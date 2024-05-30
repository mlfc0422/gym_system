package com.mlfc.service;

import com.mlfc.entity.Facility;

import java.util.List;

public interface FacilityService {

    List<Facility> facilityList();

    void insertFacility(Facility facility, int root_id);

    void updateFacility(Facility facility, int root_id);

    void delete(long[] ids);
}
