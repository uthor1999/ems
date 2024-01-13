package com.example.empmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.empmanagementsys.model.Employee;

//remove below repo if error happens also remove comment of
@Repository
//@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
