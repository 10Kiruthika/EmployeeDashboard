package com.EmployeeDashboard.Dashboard.service;

import com.EmployeeDashboard.Dashboard.entity.Employee;
import com.EmployeeDashboard.Dashboard.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;

    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    public Employee getEmployee(Long id) {
        return repo.findById(id).orElseThrow(()->{
            return new RuntimeException("Employee Not Found");
        });
    }

    public String addEmployee(Employee employee) {
        repo.save(employee);
        return "Employee Added Successfully";
    }

    public String updateEmployee(Long id,Employee employee) {
        if(repo.existsById(id)){
            repo.save(employee);
            return "Employee Updated Successfully";
        }
        else{
            throw new RuntimeException("Employee Not Found");
        }
    }

    public String deleteEmployee(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Employee Deleted Successfully";
        }
        else{
            throw new RuntimeException("Employee Not Found");
        }
    }
}
