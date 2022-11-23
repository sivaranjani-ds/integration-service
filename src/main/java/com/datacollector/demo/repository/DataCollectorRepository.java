package com.datacollector.demo.repository;

import java.util.List;

public interface DataCollectorRepository {
    List<String> getTableDetails(String schemaName);
}
