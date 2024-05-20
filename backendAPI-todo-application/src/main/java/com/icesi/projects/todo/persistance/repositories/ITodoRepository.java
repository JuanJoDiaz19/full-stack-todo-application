package com.icesi.projects.todo.persistance.repositories;

import com.icesi.projects.todo.persistance.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository extends JpaRepository<Todo, Long> {
}
