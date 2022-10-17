package com.PreProj.PP_3_1_2.controller;


import com.PreProj.PP_3_1_2.service.RoleServiceImpl;
import com.PreProj.PP_3_1_2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping()
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    RoleServiceImpl roleService;
    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/admin/users")
    public String showAll(Model model) {
        return "all-users";
    }

    @GetMapping("/user")
    public String showUserById(Model model) {
        return "userpage";
    }

    @GetMapping("/default")
    public String redirectToUserID() {
        return "redirect:/user";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

}
