package org.example.app.repository;

import org.example.app.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<List<Employee>> findByFirstName(String firstName);
    Optional<List<Employee>> findByLastName(String lastName);
    Optional<Employee> findFirstByOrderByIdDesc();
}
