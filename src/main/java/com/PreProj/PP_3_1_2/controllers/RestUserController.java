package com.PreProj.PP_3_1_2.controllers;
import com.PreProj.PP_3_1_2.models.User;
import com.PreProj.PP_3_1_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestUserController {
    @Autowired
    private UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> showAllUsers(){
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/authority", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getAuthority(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user){
        HttpHeaders headers = new HttpHeaders();
        User userEntity = userService.getUserByName(user.getUsername());
        if (userEntity != null){
            if (userEntity.getUsername().equals(user.getUsername())){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        userService.addUser(user);
        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        HttpHeaders headers = new HttpHeaders();
        userService.updateUser(user);
        return new ResponseEntity<>(user,headers,HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        HttpHeaders headers = new HttpHeaders();
        userService.removeUserById(user.getId());
        return new ResponseEntity<>(user,headers,HttpStatus.NO_CONTENT);
    }

}
