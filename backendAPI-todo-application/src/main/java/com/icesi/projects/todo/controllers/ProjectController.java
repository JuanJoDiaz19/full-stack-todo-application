package com.icesi.projects.todo.controllers;

import com.icesi.projects.todo.persistance.models.Project;
import com.icesi.projects.todo.services.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private IProjectService projectService;


    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public Iterable<Project> findAll() {
        return this.projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project findOne(@PathVariable Long id){
        if(this.projectService.findById(id).isPresent())
            return  this.projectService.findById(id).get();
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @GetMapping("/name/{name}")
    public Project findByName(@PathVariable String name){
        if(this.projectService.findByName(name).isPresent())
            return  this.projectService.findByName(name).get();
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
    @PostMapping
    public Project create(@RequestBody Project newProject){
        return this.projectService.save(newProject);
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project newProject){
        if(this.projectService.findById(id).isPresent())
            return this.projectService.save(newProject);
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

}
