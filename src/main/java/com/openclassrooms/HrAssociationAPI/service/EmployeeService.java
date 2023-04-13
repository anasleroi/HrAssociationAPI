package com.openclassrooms.HrAssociationAPI.service;

import com.openclassrooms.HrAssociationAPI.model.Employee;
import com.openclassrooms.HrAssociationAPI.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Data
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    public Employee getByMail(String mail){

        return employeeRepository.findEmployeeByMail(mail);
    }

    public Employee createEmployee( Employee employee) {
        Employee employeebymail = getByMail(employee.getMail());
        if (employeebymail == null) {
            Employee creatEmploye = new Employee();
            String firstName = employee.getFirstName();
            if (firstName != null) {
                creatEmploye.setFirstName(firstName);
            }
            String lastName = employee.getLastName();
            if (lastName != null) {
                creatEmploye.setLastName((lastName));
            }
            String mailemplyee = employee.getMail();
            if (mailemplyee != null) {
                creatEmploye.setMail((mailemplyee));
            }
            String password = employee.getPassword();
            if (password != null) {
                creatEmploye.setPassword((password));
            }
            saveEmployee(creatEmploye);
            return creatEmploye;
        } else return null;
    }
	
	public Employee majEmployee(final Long id , @RequestBody Employee employee){
}