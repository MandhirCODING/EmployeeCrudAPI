package com.example.employeeApi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeApi.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
