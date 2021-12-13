package com.okarin.controllers;

import com.okarin.DeveloperService;
import com.okarin.entity.Developer;
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

    @Autowired
    public DeveloperRestController(DeveloperService developerService) {
        this.developerService = developerService;
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
    @PostMapping
    public ResponseEntity<Long> newDeveloper(@RequestBody Developer developer){
        return new ResponseEntity<>(developerService.create(developer),HttpStatus.CREATED);
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
