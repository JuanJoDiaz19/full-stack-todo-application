package com.icesi.projects.todo.services;

import com.icesi.projects.todo.persistance.models.Todo;

import java.util.Optional;

public interface ITodoService {
    Optional<Todo> findById(Long id);
    Iterable<Todo> findAll(int page,int size,String sort, String order);

    Todo save(Todo Task);
}
