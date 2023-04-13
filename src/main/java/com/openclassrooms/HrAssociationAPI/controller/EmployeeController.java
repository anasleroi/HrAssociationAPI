package com.openclassrooms.HrAssociationAPI.controller;

import com.openclassrooms.HrAssociationAPI.model.Employee;
import com.openclassrooms.HrAssociationAPI.service.EmployeeService;
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
    public Employee requestCreateEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    /*TEST*/

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    @PutMapping("/employee/{id}")
    public Employee putEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> emp = employeeService.getEmployee(id);
        if (emp.isPresent()) {
            Employee employeExistant = emp.get();

            String firstName = employee.getFirstName();
            if (firstName != null) employeExistant.setFirstName(firstName);
            String lastName = employee.getLastName();
            if (lastName != null) employeExistant.setLastName((lastName));
            String mail = employee.getMail();
            if (mail != null) employeExistant.setMail((mail));
            String password = employee.getPassword();
            if (password != null) employeExistant.setPassword((password));

            employeeService.saveEmployee(employeExistant);
            return employeExistant;
        } else return null;
    }
}
