package com.PreProj.PP_3_1_2.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.PreProj.PP_3_1_2.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
<<<<<<< HEAD
    User findById(long id);

    @Query("from User")
    List<User> findAllBy();
=======

>>>>>>> PP_3_1_3
}
