package com.EmployeeDashboard.Dashboard.controller;

import com.EmployeeDashboard.Dashboard.entity.Employee;
import com.EmployeeDashboard.Dashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping()
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return service.getEmployee(id);
    }

    @PostMapping()
    public String addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @RequestBody Employee employee){
        return service.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return service.deleteEmployee(id);
    }
}
