package com.okarin.controllers;

import com.okarin.ProjectService;
import com.okarin.ProjectServiceImpl;
import com.okarin.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProjectRestController {

    private final ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<Project> projects(){
        List<Project> allProjects=projectService.findAll();
        return allProjects;
    }
}
