package com.icesi.projects.todo.persistance.repositories;

import com.icesi.projects.todo.persistance.models.Project;
import com.icesi.projects.todo.persistance.models.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findByName(String name);
}
