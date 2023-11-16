package com.ilkay.service.impl;

import com.ilkay.dto.ProjectDTO;
import com.ilkay.dto.UserDTO;
import com.ilkay.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {


    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }


    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }


    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream()
                .filter(user -> user.getRole().getId()==2)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return super.findAll().stream().filter(user -> user.getRole().getId() == 3).collect(Collectors.toList());
    }
}











