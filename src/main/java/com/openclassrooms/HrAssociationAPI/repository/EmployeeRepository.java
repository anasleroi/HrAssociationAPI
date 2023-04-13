package com.openclassrooms.HrAssociationAPI.repository;

import com.openclassrooms.HrAssociationAPI.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findEmployeeByMail(String mail);
}
