package com.PreProj.PP_3_1_2.controllers;

import com.PreProj.PP_3_1_2.services.RoleService;
import com.PreProj.PP_3_1_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/user")
    public String userInfo(Model model){
        return "userpage";
    }

    @GetMapping(value = "/admin/users")
    public String listUsers(Model model) {
        return "all-users";
    }

    @GetMapping("/default")
    public String redirectToUserID() {
        return "redirect:/user";
    }

    @GetMapping(value ="/login")
    public String login(){
        return "login";
    }
}
