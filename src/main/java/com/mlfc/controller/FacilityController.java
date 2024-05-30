package com.mlfc.controller;

import com.mlfc.common.Rest;
import com.mlfc.entity.Facility;
import com.mlfc.service.FacilityService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;

    @GetMapping("/list")
    public Rest<List<Facility>> selectFacility() {
        List<Facility> facilitiyList = facilityService.facilityList();
        return Rest.success(facilitiyList);
    }

    @PostMapping()
    public Rest<String> insertFacility(@RequestBody Facility facility, HttpServletRequest request) {
        int root_id = (int) request.getSession().getAttribute("root");
        facilityService.insertFacility(facility, root_id);
        return Rest.success("添加成功");
    }

    //    UPDATE
    @PutMapping
    public Rest<String> updateFacility(@RequestBody Facility facility, HttpServletRequest request) {
        int root_id = (int) request.getSession().getAttribute("root");
        facilityService.updateFacility(facility, root_id);
        return Rest.success("更新成功");
    }

    //    DELETE
    @DeleteMapping()
    public Rest<String> delete(@RequestBody long[] ids) {
        facilityService.delete(ids);
        return Rest.success("删除成功");
    }
}
