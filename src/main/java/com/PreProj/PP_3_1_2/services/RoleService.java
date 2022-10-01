package com.PreProj.PP_3_1_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PreProj.PP_3_1_2.DAO.RoleRepository;
import com.PreProj.PP_3_1_2.models.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void createRole(Role role) {roleRepository.save(role);}

    public void deleteRole(Long id) {roleRepository.deleteById(id);}

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
