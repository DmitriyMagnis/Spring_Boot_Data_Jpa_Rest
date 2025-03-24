package org.example.app.service;

import org.example.app.dto.EmployeeDtoRequest;
import org.example.app.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends BaseService<Employee, EmployeeDtoRequest> {
    Employee create(EmployeeDtoRequest request);
    Optional<List<Employee>> getAll();
    Employee getById(Long id);
    Employee updateById(Long id, EmployeeDtoRequest request);
    boolean deleteById(Long id);
    Employee findFirstByOrderByIdDesc();
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
}
