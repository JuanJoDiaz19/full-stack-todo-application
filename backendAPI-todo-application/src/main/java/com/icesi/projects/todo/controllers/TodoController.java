package com.icesi.projects.todo.controllers;

import com.icesi.projects.todo.persistance.models.Todo;
import com.icesi.projects.todo.services.ITodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/todos")
//@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class TodoController {

    private ITodoService todoService;


    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public Iterable<Todo> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(required=false) String sort, @RequestParam(defaultValue="asc") String order) {
        return this.todoService.findAll(page, size, sort, order);
    }

    @GetMapping("/{id}")
    public Todo findOne(@PathVariable Long id){
        if(this.todoService.findById(id).isPresent())
            return  this.todoService.findById(id).get();
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @PostMapping
    public Todo create(@RequestBody Todo newTask){
        return this.todoService.save(newTask);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo newTask){
        if(this.todoService.findById(id).isPresent())
            return this.todoService.save(newTask);
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

}
