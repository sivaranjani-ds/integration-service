package com.datacollector.demo.service;

import com.datacollector.demo.model.Employee;
import com.datacollector.demo.repository.GCPStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GCPStorageService {

    @Autowired
    GCPStorageRepository gcpStorageRepository;
    public void saveData(List<Employee> employees) {
        gcpStorageRepository.saveAll(employees);
    }
}
