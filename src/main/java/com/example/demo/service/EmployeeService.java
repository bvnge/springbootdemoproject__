package com.example.demo.service;


import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findByFirstName(String firstName);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

	Optional<Employee> findById(Long id);

}
