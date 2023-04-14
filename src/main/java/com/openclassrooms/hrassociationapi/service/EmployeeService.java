package com.openclassrooms.hrassociationapi.service;

import com.openclassrooms.hrassociationapi.model.Employee;
import com.openclassrooms.hrassociationapi.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveEmployee(Employee employee) {
         employeeRepository.save(employee);
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
	public Employee getByid(Long id)
    {
        return employeeRepository.findEmployeeById(id);
    }
	public Employee majEmployee(Employee employee){
		Employee majEmp=getByid(employee.getId());
		if(majEmp!=null){
			String firstName=employee.getFirstName();
			if (firstName!=null){majEmp.setFirstName(firstName);}
			String lastName=employee.getLastName();
			if (lastName!=null){majEmp.setLastName(lastName);}
			String mail=employee.getMail();
			if(mail!=null){majEmp.setMail(mail);}
			String password=employee.getPassword();
			if(password!=null){majEmp.setPassword(password);}
			saveEmployee(majEmp);
			return majEmp;
		} return null;
		
	}
}