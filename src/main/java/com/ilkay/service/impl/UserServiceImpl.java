package com.ilkay.service.impl;

import com.ilkay.dto.ProjectDTO;
import com.ilkay.dto.UserDTO;
import com.ilkay.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}











