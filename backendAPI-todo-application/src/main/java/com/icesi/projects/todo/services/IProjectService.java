package com.icesi.projects.todo.services;

import com.icesi.projects.todo.persistance.models.Project;

import java.util.Optional;

public interface IProjectService {
    Optional<Project> findById(Long id);
    Optional<Project> findByName(String name);
    Iterable<Project> findAll();

    Project save(Project project);
}
