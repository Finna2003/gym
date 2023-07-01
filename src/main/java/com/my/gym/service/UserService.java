package com.my.gym.service;

import com.my.gym.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User create(User user);
    User readById(long id);
    User update(User user);
    void delete(long id);
    List<User> getAll();
    User findByEmail(String email);

    UserDetails loadUserByUsername(String email);
}
