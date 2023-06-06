package com.ablacky.proman;

import java.sql.Date;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ablacky.proman.project.Project;
import com.ablacky.proman.project.ProjectRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    
    @Autowired 
    private ProjectRepository repo;

    @Test
    public void testAddNew(){
        Project project = new Project();
        project.setTitle("Project and publication management");
        project.setAbout("Project and publication management Project and publication management Project and publication management");
        project.setStartDate(Date.valueOf("2023-05-01"));
        project.setEndDate(Date.valueOf("2023-09-10"));

        Project savedProject = repo.save(project);
        Assertions.assertThat(savedProject).isNotNull();
        Assertions.assertThat(savedProject.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Project> projects = repo.findAll();
        Assertions.assertThat(projects).hasSizeGreaterThan(0);
    }



}