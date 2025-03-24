package org.example.app.service;

import org.example.app.dto.EmployeeDtoRequest;
import org.example.app.entity.Employee;
import org.example.app.entity.EmployeeMapper;
import org.example.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee create(EmployeeDtoRequest request) {
        Objects.requireNonNull(request,
                "Parameter [request] must not be null!");
        Employee employee = mapper.dtoCreateToEntity(request);
        return employeeRepository.save(employee);
    }
    @Override
    @Transactional
    public Optional<List<Employee>> getAll() {
        Iterable<Employee> iterable = employeeRepository.findAll();
        List<Employee> list =
                StreamSupport.stream(iterable.spliterator(), false)
                        .toList();
        return Optional.of(list);
    }
    @Override
    @Transactional
    public Employee getById(Long id) {
        Objects.requireNonNull(id,
                "Parameter [id] must not be null!");
        return employeeRepository.findById(id)
                .orElse(null);
    }
    @Override
    @Transactional
    public Employee updateById(Long id, EmployeeDtoRequest request) {
        Objects.requireNonNull(request,
                "Parameter [request] must not be null!");
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided!");
        }
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            Employee employeeToUpdate =
                    mapper.dtoUpdateToEntity(id, request,
                            optional.get());
            employeeRepository.save(employeeToUpdate);
        }
        return employeeRepository.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public boolean deleteById(Long id) {
        Objects.requireNonNull(id,
                "Parameter [id] must not be null!");
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Employee findFirstByOrderByIdDesc() {
        return employeeRepository.findFirstByOrderByIdDesc()
                .orElse(null);
    }

    @Override
    @Transactional
    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName)
                .orElse(Collections.emptyList());
    }

    @Override
    @Transactional
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName)
                .orElse(Collections.emptyList());
    }
}
