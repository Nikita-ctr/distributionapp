package com.okarin.controllers;

import com.okarin.DeveloperService;
import com.okarin.ProjectService;
import com.okarin.entity.Developer;
import com.okarin.entity.Project;
import com.okarin.exceptions.ProjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/developers")
public class DeveloperRestController {

    private final DeveloperService developerService;
    private final ProjectService projectService;


    @Autowired
    public DeveloperRestController(DeveloperService developerService, ProjectService projectService) {
        this.developerService = developerService;
        this.projectService = projectService;
    }
    @GetMapping
    public ResponseEntity<List<Developer>> developers(){
        return new ResponseEntity<>(developerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Developer> getDeveloper(@PathVariable Long id){
        Optional<Developer> optional=developerService.findById(id);
        return optional.map(developer -> new ResponseEntity<>(developer, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //todo
    @PostMapping("{projectId}")
    public ResponseEntity<Long> newDeveloper(@PathVariable (value = "projectId") Long projectId, @RequestBody Developer developer){
        Optional<Project> project=projectService.findById(projectId);
        if (project.isPresent()){
            developer.setProject(project.get());
                   project.get().getDevelopers().add(developer);
            return new ResponseEntity<>(developerService.create(developer),HttpStatus.CREATED);
        } else {
            throw new ProjectNotFoundExeption(projectId);
        }
    }
    @PutMapping
    public ResponseEntity<Long> updateDeveloper(@RequestBody Developer developer){
        return new ResponseEntity<>(developerService.update(developer),HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Long id){
        developerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
