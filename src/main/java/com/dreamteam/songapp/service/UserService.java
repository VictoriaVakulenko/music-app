package com.dreamteam.songapp.service;

import com.dreamteam.songapp.dto.UserRegistrationDto;
import com.dreamteam.songapp.enteties.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDto registrationDto);
    String getUserPassword(String email);
    List<User> getAll();
    void deleteUser(Long id);
}
