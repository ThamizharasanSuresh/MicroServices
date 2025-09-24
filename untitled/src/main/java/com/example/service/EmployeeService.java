package com.example.service;



import com.example.entity.Employee;
import com.example.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(Long id){
        return employeeRepository.findById(id);
    }
}
