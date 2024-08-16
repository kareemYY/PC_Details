package com.kareem.PC_Details.service.impl;


import com.kareem.PC_Details.dto.EmployeeDto;
import com.kareem.PC_Details.entity.Employee;
import com.kareem.PC_Details.repository.EmployeeRepository;
import com.kareem.PC_Details.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();

        return employees.stream().map(employee -> mapper.map(employee,EmployeeDto.class)).toList();
    }
}
