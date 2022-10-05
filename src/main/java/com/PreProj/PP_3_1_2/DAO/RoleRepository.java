package com.PreProj.PP_3_1_2.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.PreProj.PP_3_1_2.models.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
<<<<<<< HEAD
    Role findByRole(String role);
    Role findByName(String name);
    @Query("from Role")
    List<Role> findAllByRole();
=======
    Role findByName(String name);
>>>>>>> PP_3_1_3
}
