package com.ablacky.proman.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    @Autowired private ProjectRepository repo;

    public List<Project> listAll() {
        return (List<Project>) repo.findAll();
    }

    public void save(Project project) {
        repo.save(project);
    }

    public Project get(Integer id) throws ProjectNotFoundException {

        Optional<Project> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }

        throw new ProjectNotFoundException("Could not find any Project with ID: "+id);

    }
}