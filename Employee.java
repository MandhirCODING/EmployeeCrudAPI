package com.example.employeeApi.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeedb")
public class Employee {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	
	@Column(name="empid")
	private int empid;
	@Column(name="emp_name")
	private String emp_name;
	@Column(name = "emp_salary")
	private float emp_salary;
	@Column(name= "emp_age")
	private int emp_age;
	@Column(name= "emp_city" )
	private String  emp_city;
	/**
	 * @return the empid
	 */
	
	public int getEmpid() {
		return empid;
	}
	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	/**
	 * @return the emp_name
	 */
	public String getEmp_name() {
		return emp_name;
	}
	/**
	 * @param emp_name the emp_name to set
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	/**
	 * @return the emp_salary
	 */
	public float getEmp_salary() {
		return emp_salary;
	}
	/**
	 * @param emp_salary the emp_salary to set
	 */
	public void setEmp_salary(float emp_salary) {
		this.emp_salary = emp_salary;
	}
	/**
	 * @return the emp_age
	 */
	public int getEmp_age() {
		return emp_age;
	}
	/**
	 * @param emp_age the emp_age to set
	 */
	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}
	/**
	 * @return the emp_city
	 */
	public String getEmp_city() {
		return emp_city;
	}
	/**
	 * @param emp_city the emp_city to set
	 */
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	public Employee(int empid, String emp_name, float emp_salary, int emp_age, String emp_city) {
		
		this.empid = empid;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_age = emp_age;
		this.emp_city = emp_city;
	}
	
	public Employee() {
		
		
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", emp_name=" + emp_name + ", emp_salary= "+ emp_salary +" , emp_age="
				+ emp_age + ", emp_city=" + emp_city + "]";
	}
	
}
