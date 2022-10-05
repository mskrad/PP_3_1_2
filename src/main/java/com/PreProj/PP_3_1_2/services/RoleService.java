package com.PreProj.PP_3_1_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PreProj.PP_3_1_2.DAO.RoleRepository;
import com.PreProj.PP_3_1_2.models.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private RoleRepository roleRepository;
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;;
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public void updateRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

    public void removeRoleById(long id) { roleRepository.deleteById((long) id); }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByName(String name) { return roleRepository.findByName(name); }
}
