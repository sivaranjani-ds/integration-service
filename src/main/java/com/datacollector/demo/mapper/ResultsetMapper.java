package com.datacollector.demo.mapper;

import com.datacollector.demo.model.Employee;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultsetMapper {

    public List<String> tableNameMapper(ResultSet resultSet) throws SQLException {
        List<String> tableNames = new ArrayList<>();
        while (resultSet.next()) {
            tableNames.add(resultSet.getString("tableName"));
        }
        return tableNames;
    }
    public List<Employee> employeeMapper(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            employees.add(
                    new Employee(
                            resultSet.getLong("id"),
                            resultSet.getString("name")
                    ));
        }
        return employees;
    }
}
