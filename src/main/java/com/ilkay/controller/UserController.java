package com.ilkay.controller;

import com.ilkay.dto.UserDTO;
import com.ilkay.service.RoleService;
import com.ilkay.service.UserService;
import com.ilkay.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }


    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model) {

        userService.save(user);

        return "redirect:/user/create";

    }
//    @GetMapping("/update/{username}")
//    public String editUser(@PathVariable("username") String username, Model model){

               //work here
        //Define the attributes.  we need user, roles, users
        //this part for just retrieving data, to save update wee need a postmapping method. Write it below this one.

        @GetMapping("/update/{username}")
        public String editUser(@PathVariable("username") String username,Model model){

            model.addAttribute("user",userService.findById(username));
            model.addAttribute("roles",roleService.findAll());
            model.addAttribute("users",userService.findAll());


            return "/user/update";

        }

        @PostMapping("/update")
        public String updateUser(UserDTO user){

            userService.update(user);

            return "redirect:/user/create";

        }

}





