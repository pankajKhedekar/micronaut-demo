package com.example.repository;

import com.example.model.Employee;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface EmployeeMicronautRepository extends CrudRepository<Employee, Long> {

    Employee save(Employee employee);
}
