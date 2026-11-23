package com.EmployeeDashboard.Dashboard.repository;

import com.EmployeeDashboard.Dashboard.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
