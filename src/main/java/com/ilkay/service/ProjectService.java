package com.ilkay.service;

import com.ilkay.dto.ProjectDTO;
import com.ilkay.dto.UserDTO;

import java.util.List;


public interface ProjectService extends CrudService<ProjectDTO, String> {

    void complete(ProjectDTO project);

    List<ProjectDTO> findAllNonCompletedProjects();

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);

}