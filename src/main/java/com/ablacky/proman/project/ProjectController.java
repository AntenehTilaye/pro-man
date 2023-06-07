package com.ablacky.proman.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProjectController {

    @Autowired private ProjectService projectService;

    @GetMapping("/projects")
    public String showProjectList(Model model) {
        List<Project> projects = projectService.listAll();
        model.addAttribute("projects", projects);
        return "projects";
        
    }

    @GetMapping("/projects/create")
    public String showAddProject(Model model) {
        
        model.addAttribute("project", new Project());
        return "create";
        
    }
    
    @PostMapping("/projects/save")
    public String saveProject(Project project, RedirectAttributes ra) {
        
        projectService.save(project);
        ra.addFlashAttribute("message", "The Project is added Successfully ");
        return "redirect:/projects";
    }
}