package com.example.feign;


import com.example.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient("PROJECT-SERVICE")
public interface ProjectInterface {

    @PostMapping("/project")
    public ResponseEntity<String> addProject(@RequestBody Project project);

    @GetMapping("/project/{id}")
    public ResponseEntity<Optional<Project>> getProjectbyID(@PathVariable Long id);
}
