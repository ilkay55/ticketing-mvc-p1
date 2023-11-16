package com.ilkay.service;

import com.ilkay.dto.ProjectDTO;


public interface ProjectService extends CrudService<ProjectDTO, String> {

    void complete(ProjectDTO project);

}