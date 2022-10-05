package com.PreProj.PP_3_1_2.services;

import com.PreProj.PP_3_1_2.DAO.UserRepository;
import com.PreProj.PP_3_1_2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
<<<<<<< HEAD
@Transactional
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
=======
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

>>>>>>> PP_3_1_3
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUser(User user) {
        if (user.getPassword().equals(getUserById(user.getId()).getPassword())) {
            user.setPassword(getUserById(user.getId()).getPassword());
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userRepository.saveAndFlush(user);
    }

    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

<<<<<<< HEAD
    public User getUserById(long id) { return userRepository.findById(id); }

    public List<User> getAllUsers() { return userRepository.findAllBy(); }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
=======
    public User getUserById(long id) { return userRepository.findById(id).get(); }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found " + username);
        }
        return user;
>>>>>>> PP_3_1_3
    }
}
