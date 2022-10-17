package com.PreProj.PP_3_1_2.service;


import com.PreProj.PP_3_1_2.model.Role;

import java.util.List;

public interface RoleService {
    void createRole(Role role);
    void deleteRole(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
}
