package com.example.employeeApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeApi.Model.Employee;
import com.example.employeeApi.Repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@PostMapping("/employees")
	public String createNewEmp(@RequestBody  Employee employee) {
		employeeRepository.save(employee);
		return "employees ";
	}

}
