package org.example.orgmanager.repository;

import org.example.orgmanager.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameOrderBySalaryDesc(String name);
}
