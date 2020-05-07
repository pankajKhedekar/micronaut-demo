package com.example.controller;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

@Controller("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Inject
    EmployeeRepository repository;

    @Post
    public Employee add(@Body Employee newEmployee){
        LOGGER.info("Employee add: {}", newEmployee);
        return repository.add(newEmployee);
    }

    @Get("/{id}")
    public Employee findById(Long id){
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @Get("/department/{departmentId}")
    @ContinueSpan
    public List<Employee> findByDepartment(@SpanTag("departmentId") Long departmentId) {
        LOGGER.info("Employees find with department id: id={}", departmentId);
        return repository.findByDepartment(departmentId);
    }
    @Get("/organization/{organizationId}")
    @ContinueSpan
    public List<Employee> findByOrganization(@SpanTag("organizationId") Long organizationId) {
        LOGGER.info("Employees find with organization id: id={}", organizationId);
        return repository.findByOrganization(organizationId);
    }
}
