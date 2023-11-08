package com.ilkay.controller;

import com.ilkay.dto.UserDTO;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
      //  model.addAttribute("roles", bringmeLISTOFROLES); //bring me all roles from DB
        return "/user/create";
    }
}
