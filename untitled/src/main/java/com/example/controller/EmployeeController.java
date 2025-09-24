package com.example.controller;



import com.example.dto.EmployeeDTO;
import com.example.entity.Employee;
import com.example.entity.Project;
import com.example.feign.ProjectInterface;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProjectInterface projectInterface;

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
       Optional<Project> project=projectInterface.getProjectbyID(employee.getAssingedProject()).getBody();

        if(project.isEmpty()){
            return  new ResponseEntity<>("Unable to find project details", HttpStatus.BAD_REQUEST);
        }
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Employee Added Successfully",HttpStatus.ACCEPTED);
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmp(@PathVariable Long id){
        Optional<Employee> employee=employeeService.getEmployee(id);
        Optional<Project> project=projectInterface.getProjectbyID(employee.get().getAssingedProject()).getBody();

        EmployeeDTO employeeDTO = new EmployeeDTO();

        if(project.isEmpty()){
            employeeDTO.setId(employee.get().getId());
            employeeDTO.setName(employee.get().getName());
            employeeDTO.setEmail(employee.get().getEmail());
            employeeDTO.setLocation(employee.get().getLocation());
            return new ResponseEntity<>(employeeDTO,HttpStatus.BAD_REQUEST);
        }
        else {
            employeeDTO.setId(employee.get().getId());
            employeeDTO.setName(employee.get().getName());
            employeeDTO.setEmail(employee.get().getEmail());
            employeeDTO.setLocation(employee.get().getLocation());
            employeeDTO.setAssingedProject(project.get().getId());
            employeeDTO.setProjectName(project.get().getName());
            return new ResponseEntity<>(employeeDTO,HttpStatus.ACCEPTED);
        }
    }

}
