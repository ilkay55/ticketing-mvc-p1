package com.ilkay.controller;

import com.ilkay.dto.ProjectDTO;
import com.ilkay.service.ProjectService;
import com.ilkay.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;

    UserService userService;


        public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }
    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findAll());
        return "/project/create";

    }
}
