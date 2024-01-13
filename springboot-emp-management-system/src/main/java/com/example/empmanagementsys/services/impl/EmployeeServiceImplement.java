package com.example.empmanagementsys.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empmanagementsys.exception.ResourceNotFoundException;
import com.example.empmanagementsys.model.Employee;
import com.example.empmanagementsys.repository.EmployeeRepository;
import com.example.empmanagementsys.services.EmployeeServices;

@Service
public class EmployeeServiceImplement implements EmployeeServices {

	private EmployeeRepository employeeRepository;
	//remove below if error occured
	@Autowired
	public EmployeeServiceImplement(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	//add employee in db
	@Override
	public Employee saveEmployee(Employee employee) {
			return employeeRepository.save(employee);
		
	}

	//get all employee
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	//get employee by id
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		//you can also use lambda expression instead of if-else statement
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "Id",id);
		}
	}

	//to update employee by id in db
	@Override
	public Employee updateEmployee(Employee employee, long id) {
			Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Employee","Id", id)
					);
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
	//saving updated info to database
			employeeRepository.save(existingEmployee);
			return existingEmployee;
	}

//to delete employee from db by id
	@Override
	public void removeEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}
	
}
