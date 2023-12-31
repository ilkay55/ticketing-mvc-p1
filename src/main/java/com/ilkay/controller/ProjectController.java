package com.ilkay.controller;

import com.ilkay.dto.ProjectDTO;
import com.ilkay.dto.UserDTO;
import com.ilkay.service.ProjectService;
import com.ilkay.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ilkay.enums.Status;

import java.util.List;

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
    public String deleteProject(@PathVariable("projectcode") String projectcode) {
        projectService.deleteById(projectcode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectcode) {
        projectService.complete(projectService.findById(projectcode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String editProject(@PathVariable("projectcode") String projectcode, Model model) {

        model.addAttribute("project", projectService.findById(projectcode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/update";

    }

    @PostMapping("/update")
    public String updateProject(ProjectDTO project) {

        projectService.update(project);

        return "redirect:/project/create";

    }


    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model){

        UserDTO manager = userService.findById("john@cydeo.com");

        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);

        model.addAttribute("projects",projects);

        return "/manager/project-status";
    }

    @GetMapping("/manager/complete/{projectCode}")
    public String managerCompleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/manager/project-status";
    }

}

