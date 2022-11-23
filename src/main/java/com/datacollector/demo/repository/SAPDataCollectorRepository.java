package com.datacollector.demo.repository;

import com.datacollector.demo.model.Employee;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Log
public class SAPDataCollectorRepository implements DataCollectorRepository  {

    @Value("${sap.connection.url}")
    private String url;

    @Value("${sap.connection.username}")
    private String username;

    @Value("${sap.connection.password}")
    private String password;

    @Override
    public List<String> getTableDetails(String schemaName) {
        List<String> tableNames = new ArrayList<>();
        Connection connection = getSAPConnection(url, username, password);
        if (connection != null) {
            try {
                String query = "Select TABLE_NAME as tableName from TABLES WHERE SCHEMA_NAME='" + schemaName + "'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = executeQuery(statement, query);
                while (resultSet.next()) {
                    tableNames.add(resultSet.getString(1));
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                log.info("Query failed!" + e);
            }
        }
        return tableNames;
    }

    public List<Employee> getEmployeeDetails(String tableName) {
        List<Employee> employees = new ArrayList<Employee>();
        Connection connection = getSAPConnection(url, username, password);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "Select ID as id, NAME as name from " + tableName;
                ResultSet resultSet = executeQuery(statement, query);

                while (resultSet.next()) {
                    employees.add(
                            new Employee(
                                    resultSet.getInt(1),
                                    resultSet.getString(2)
                            ));
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                log.info("Query failed!" + e);
            }
        }
        return employees;
    }

    private static Connection getSAPConnection(String url, String username, String password) {
        try {
            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            log.info("SAP Connection error " + e);
            return null;
        }
    }

    private ResultSet executeQuery(Statement statement, String query) throws SQLException {
        log.info("Connection to HANA successful!");
        return statement.executeQuery(query);
    }

}
