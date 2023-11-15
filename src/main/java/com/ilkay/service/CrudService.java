package com.ilkay.service;

import com.ilkay.dto.ProjectDTO;

import java.util.List;

public interface CrudService<T, ID> {

    //save, findByID, delete, findAll

    T save(T object);

    List<T> findAll();

  T findById(ID id);

//    void delete(T object);  // removed because i do not need a delete method for the moment

    void deleteById(ID id);

    void update(T object);

}


//
//    UserDTO save(UserDTO user);
//
//    UserDTO findById(String username);
//
//    List<UserDTO> findAll();
//
//    void delete(UserDTO role);
//
//    void deleteByID(String username);
//-----------------------------------
//    RoleDTO save (RoleDTO role);
//    RoleDTO findByID (Long id);
//    List<RoleDTO> findAll();
//    void delete (RoleDTO role);
//    void deleteByID (Long ID);


