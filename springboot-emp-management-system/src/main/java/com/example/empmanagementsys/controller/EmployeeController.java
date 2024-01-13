package com.example.empmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empmanagementsys.model.Employee;
import com.example.empmanagementsys.services.EmployeeServices;
@Controller
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
	private EmployeeServices employeeServices;

	//remove for error
	@Autowired
	public EmployeeController(EmployeeServices employeeServices) {
		super();
		this.employeeServices = employeeServices;
	}
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listemployees", employeeServices.getAllEmployees());
		return "index";
	}

	//build create/add employee rest api
	//you can add url employee below also
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeServices.saveEmployee(employee),HttpStatus.CREATED);

	}

	//get all employees rest api
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeServices.getAllEmployees();
	}
	
	//get employee by id rest api
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeServices.getEmployeeById(employeeId),HttpStatus.OK);	
	}
	
	//update employee by rest api
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeServices.updateEmployee(employee, id), HttpStatus.OK);
		
	}
 
	//delete employee by rest api
	@DeleteMapping("{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable("id") long id){
		employeeServices.removeEmployee(id);
		return new ResponseEntity<String>(" Employee deleted successfully", HttpStatus.OK);
		
	}
}
