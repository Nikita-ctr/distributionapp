package com.okarin.controllers;

import com.okarin.ProjectService;
import com.okarin.ProjectServiceImpl;
import com.okarin.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    private final ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public ResponseEntity<List<Project>> projects(){
        return new ResponseEntity<>(projectService.findAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id){
        Optional<Project> optional=projectService.findById(id);
        return optional.map(project -> new ResponseEntity<>(project, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Long> newProject(@RequestBody Project project){
        return new ResponseEntity<>(projectService.create(project),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Long> updateProject(@RequestBody Project project){
        return new ResponseEntity<>(projectService.update(project),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id){
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
