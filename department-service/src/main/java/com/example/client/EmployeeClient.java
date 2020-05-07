package com.example.client;

import com.example.model.Employee;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client(id = "employee-service", path = "/employees")
public interface EmployeeClient {

    @Get("/department/{departmentId}")
    List<Employee> findByDepartment(Long departmentId);

}
