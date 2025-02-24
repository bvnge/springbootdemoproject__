package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{
	Optional<Employee> findById(Long id);
	List<Employee> findByFirstName(String firstName);
}
