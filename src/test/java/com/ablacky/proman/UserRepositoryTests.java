package com.ablacky.proman;

import java.sql.Date;

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
        project.setTitle("Workflow Management System");
        project.setAbout("Workflow Management System Workflow Management System Workflow Management System");
       
        ;
    }

}