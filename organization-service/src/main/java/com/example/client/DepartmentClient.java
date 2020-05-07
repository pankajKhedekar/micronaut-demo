package com.example.client;

import com.example.model.Department;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client(id = "department-service", path = "/departments")
public interface DepartmentClient {

    @Get("/organization/{organizationId}")
    List<Department> findByOrganization(Long organizationId);

    @Get("/organization/{organizationId}/with-employees")
    List<Department> findByOrganizationWithEmployees(Long organizationId);

}
