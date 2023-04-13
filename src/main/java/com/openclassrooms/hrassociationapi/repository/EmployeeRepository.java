package com.openclassrooms.hrassociationapi.repository;

import com.openclassrooms.hrassociationapi.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findEmployeeByMail(String mail);
    Employee findEmployeeById(Long id);
}

