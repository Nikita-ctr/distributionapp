package com.okarin.controllers;

import com.okarin.DeveloperService;
import com.okarin.entity.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api2")
public class DeveloperRestController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperRestController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> allDev(){
        List<Developer> developers=developerService.findAll();
        return developers;
    }
}
