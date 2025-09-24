package com.example.service;





import com.example.entity.Project;
import com.example.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository studentRepository;

    public void addProject(Project project){
        studentRepository.save(project);
    }

    public Optional<Project> getProject(Long id){
        return studentRepository.findById(id);
    }
}
