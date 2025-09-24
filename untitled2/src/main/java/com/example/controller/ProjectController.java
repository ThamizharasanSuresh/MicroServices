package com.example.controller;



import com.example.entity.Project;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/project")
    public ResponseEntity<String> addProject(@RequestBody Project project){
        projectService.addProject(project);
        return  new ResponseEntity<>("Project Added Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Optional<Project>> getProjectbyID(@PathVariable Long id){

        Optional<Project> project=projectService.getProject(id);
        return new ResponseEntity<>(project,HttpStatus.ACCEPTED);
    }
}
