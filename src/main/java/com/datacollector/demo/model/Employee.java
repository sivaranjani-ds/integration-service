package com.datacollector.demo.model;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Entity (name = "Employee")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    private Long id;
    private String name;
}
