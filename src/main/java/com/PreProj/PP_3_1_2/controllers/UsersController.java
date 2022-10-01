package ru.kata.spring.boot_security.demo.controllers;

import com.PreProj.PP_3_3_1.models.User;
import com.PreProj.PP_3_3_1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/users")
public class UsersController implements WebMvcConfigurer {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "userpage";
    }

    @GetMapping("/adduser")
    public String addUser(Model model) {
        model.addAttribute("users", new User());
        return "add";
    }


    @PostMapping("/adduser")
    public String create(@ModelAttribute("users") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("users", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("users") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/{id}")
    public String deleteUser(@ModelAttribute("id") Long id){
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
