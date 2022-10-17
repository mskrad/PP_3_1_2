package com.PreProj.PP_3_1_2.service;


import com.PreProj.PP_3_1_2.model.User;

public interface UserService {
    public void addUser(User user);

    public User getUserById(long id);

    public void updateUser(User user);

    public void removeUserById(Long id);
}
