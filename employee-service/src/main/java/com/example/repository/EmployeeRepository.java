package com.example.repository;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee add(Employee newEmployee);

    Employee findById(Long id);

    List<Employee> findByDepartment(Long departmentId);

    List<Employee> findByOrganization(Long organizationId);
}



