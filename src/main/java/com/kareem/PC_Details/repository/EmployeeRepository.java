package com.kareem.PC_Details.repository;


import com.kareem.PC_Details.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
