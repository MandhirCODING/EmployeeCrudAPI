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

	@GetMapping("/employees")
	public ResponseEntity<List <Employee>> getAllEmployees(){
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);	
	}
	
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empid){
		Optional<Employee> emp= employeeRepository.findById(empid);
		
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
			
		}else {
			
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable int empid, @RequestBody Employee employee) {
		
		Optional<Employee> emp =  employeeRepository.findById(empid);
		
		if(emp.isPresent()) {
			Employee existEmp = emp.get();
			existEmp.setEmp_age(employee.getEmp_age());
			existEmp.setEmp_city(employee.getEmp_city());
			existEmp.setEmp_name(employee.getEmp_name());
			existEmp.setEmp_salary(employee.getEmp_salary());
			employeeRepository.save(existEmp);
			
				return  "Employee Details against id" +empid +  " Updated";
			
		}else {
				return  "Employee Details does not exist for empid" +empid ;
		}
	}
	
		@DeleteMapping("/employees/{empid}")
		public String deleteEmployeeById(@PathVariable int empid) {
		employeeRepository.deleteById(empid);
		
		return "Employee Delete Successfully";	
		}
		
		@DeleteMapping("/employees")
		public String deleteAllEmployee() {
			employeeRepository.deleteAll();
			return "Employee deleted Successfully";
		}
		
		@GetMapping("/employees/empcity")
		public ResponseEntity<Employee> getEmployeeByempcity(@RequestParam("emp_city") String emp_city) {
			Employee emp = employeeRepository.findByEmpcity(emp_city);
			return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
		}	
		
		@GetMapping("/employee/employeeGreaterThan")
		public ResponseEntity<List<Employee>> getEmployeeGreaterThan(@RequestParam("emp_age") int emp_age){
			Optional<List<Employee>> empList = employeeRepository.findByEmpageGreaterThan(emp_age);
			return new ResponseEntity<List<Employee>>(empList.get(), HttpStatus.FOUND);
		}
		


	
}
