package com.icesi.projects.todo.services.impl;

import com.icesi.projects.todo.persistance.models.Project;
import com.icesi.projects.todo.persistance.repositories.IProjectRepository;
import com.icesi.projects.todo.services.IProjectService;
import com.icesi.projects.todo.services.ITodoService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;

//    public ProjectServiceImpl(IProjectRepository projectRepository) {
//        this.projectRepository = projectRepository;
//    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }
    public Optional<Project> findByName(String name) {
        return projectRepository.findByName(name);
    }


    @Override
    public Iterable<Project> findAll(){
        return projectRepository.findAll();
    }
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Autowired
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
