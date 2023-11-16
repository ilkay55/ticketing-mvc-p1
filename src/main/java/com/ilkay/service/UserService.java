package com.ilkay.service;

import com.ilkay.dto.RoleDTO;
import com.ilkay.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String> {

    List<UserDTO> findManagers();


}
