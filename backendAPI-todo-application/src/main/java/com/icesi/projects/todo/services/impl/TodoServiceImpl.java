package com.icesi.projects.todo.services.impl;

import com.icesi.projects.todo.persistance.models.Todo;
import com.icesi.projects.todo.persistance.repositories.ITodoRepository;
import com.icesi.projects.todo.services.ITodoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImpl implements ITodoService {
    private ITodoRepository taskRepository;

    public TodoServiceImpl (ITodoRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Iterable<Todo> findAll(int page, int size, String sort, String order) {
        if(sort == null)
            return taskRepository.findAll(PageRequest.of(page, size));
        else
        if(order.equals("desc"))
            return taskRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Order.desc(sort))) );
        else
            return taskRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Order.asc(sort))) );

    }

    @Override
    public Todo save(Todo task) {
        return taskRepository.save(task);
    }

}
