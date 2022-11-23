package com.datacollector.demo.controller;

import com.datacollector.demo.model.Employee;
import com.datacollector.demo.service.SAPDataCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/from")
public class SAPDataCollectorController {

    @Autowired
    private SAPDataCollectorService dataCollectorService;

    @GetMapping("/sap/{schemaName}/tables")
    public List<String> getDataFromSap(
            @PathVariable String schemaName
    ) {
        return dataCollectorService.getTableDetailsFromSap(schemaName);
    }

    @GetMapping("/sap/{tableName}")
    public List<Employee> getEmployeesList(
            @PathVariable String tableName
    ) {
        return dataCollectorService.getEmployeesList(tableName);
    }
}
