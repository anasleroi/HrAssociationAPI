package com.openclassrooms.hrassociationapi.controller;

import com.openclassrooms.hrassociationapi.model.Employee;
import com.openclassrooms.hrassociationapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);

    }

    /*TEST*/
    @PostMapping("employee")
    public Employee requestCreateEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    /*TEST*/

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.orElse(null);
    }

    @PutMapping("/employee/{id}")
    public Employee putEmployee(@RequestBody Employee employee) {
        return employeeService.majEmployee(employee);
    }
}