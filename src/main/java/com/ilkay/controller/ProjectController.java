package com.ilkay.controller;

import com.ilkay.dto.ProjectDTO;
import com.ilkay.service.ProjectService;
import com.ilkay.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("managers", userService.findManagers());
        return "/project/create";

    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project) {

        projectService.save(project);

        return "redirect:/project/create";


        //when we use redirect, we do not need to write model.addAttributes again.
        //It is basically using the same attributes with the previous method(the method we redirect to).

    }

     @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectcode){
        projectService.deleteById(projectcode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectcode){
        projectService.complete(projectService.findById(projectcode));
        return "redirect:/project/create";
    }

}

