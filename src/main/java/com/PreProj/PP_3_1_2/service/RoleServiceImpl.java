package com.PreProj.PP_3_1_2.service;

import com.PreProj.PP_3_1_2.dao.RoleRepository;
import com.PreProj.PP_3_1_2.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createRole(Role role) {roleRepository.save(role);}

    public void deleteRole(Long id) {roleRepository.deleteById(id);}

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
