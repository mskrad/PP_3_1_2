package com.PreProj.PP_3_1_2.service;

import com.PreProj.PP_3_1_2.model.Role;
import com.PreProj.PP_3_1_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {
    private final UserService userService;
    private final RoleService roleService;
    final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public DBInit(UserService userService, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostConstruct
    private void postConstruct() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role(  "ROLE_USER");
        roleService.createRole(role1);
        roleService.createRole(role2);
        Set<Role> roles_admin = new HashSet<>();
        roles_admin.add(roleService.getRoleByName("ROLE_ADMIN"));
        roles_admin.add(roleService.getRoleByName("ROLE_USER"));
        User admin = new User(1, "Tim1", "Timur","Kurmangaliev", "tiktik@mail.ru", "tikoki2", roles_admin);
        userService.addUser(admin);
        Set<Role> roles_user = new HashSet<>();
        roles_user.add(roleService.getRoleByName("ROLE_USER"));
        User user = new User(2, "user", "user", "user",
                "user@user.ru", "1234",  roles_user);
        userService.addUser(user);
    }
}
