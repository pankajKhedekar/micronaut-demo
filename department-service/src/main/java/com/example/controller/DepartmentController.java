package com.example.controller;


import com.example.client.EmployeeClient;
import com.example.model.Department;
import com.example.repository.DepartmentRepository;
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

@Controller("/departments")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Inject
    DepartmentRepository repository;
    @Inject
    EmployeeClient employeeClient;

    @Post
    public Department add(@Body Department department) {
        LOGGER.info("Department add: {}", department);
        return repository.add(department);
    }

    @Get("/{id}")
    public Department findById(Long id) {
        LOGGER.info("Department find: id={}", id);
        return repository.findById(id);
    }

    @Get
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @Get("/organization/{organizationId}")
    @ContinueSpan
    public List<Department> findByOrganization(@SpanTag("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }

    @Get("/organization/{organizationId}/with-employees")
    @ContinueSpan
    public List<Department> findByOrganizationWithEmployees(@SpanTag("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        List<Department> departments = repository.findByOrganization(organizationId);
        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
        return departments;
    }

}