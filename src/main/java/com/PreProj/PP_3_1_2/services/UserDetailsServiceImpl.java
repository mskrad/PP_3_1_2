package com.example.springboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.springboot3.entity.User;


@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserService userService;
    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found " + s);
        }
        return user;
    }
}
