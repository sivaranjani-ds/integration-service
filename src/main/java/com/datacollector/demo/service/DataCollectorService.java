package com.datacollector.demo.service;

import com.datacollector.demo.model.Employee;
import com.datacollector.demo.repository.SAPDataCollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataCollectorService {

    @Autowired
    private SAPDataCollectorRepository dataCollectorRepository;
    public List<String> getTableDetailsFromSap(String schemaName) {
        return dataCollectorRepository.getTableDetails(schemaName);
    }

    public List<Employee> getEmployeesList(String tableName) {
        return dataCollectorRepository.getEmployeeDetails(tableName);
    }

}
