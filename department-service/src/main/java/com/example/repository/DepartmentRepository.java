package com.example.repository;

import com.example.model.Department;

import java.util.List;

public interface DepartmentRepository {
    Department add(Department department);

    Department findById(Long id);

    List<Department> findAll();

    List<Department> findByOrganization(Long organizationId);
}
