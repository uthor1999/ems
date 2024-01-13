package com.example.empmanagementsys.services;

import java.util.List;

import com.example.empmanagementsys.model.Employee;

public interface EmployeeServices {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void removeEmployee(long id);

}
