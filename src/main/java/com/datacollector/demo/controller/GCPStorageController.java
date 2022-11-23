package com.datacollector.demo.controller;

import com.datacollector.demo.model.Employee;
import com.datacollector.demo.service.GCPStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GCPStorageController {

    @Autowired
    private GCPStorageService gcpStorageService;

    @PostMapping ("/gcp/save-data")
    public void saveDataToGcp(
            @RequestBody Employee[] employees
        ) {
        gcpStorageService.saveData(Arrays.stream(employees).toList());
    }
}
