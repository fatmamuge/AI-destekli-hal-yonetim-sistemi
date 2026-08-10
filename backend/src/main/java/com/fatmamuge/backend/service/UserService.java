package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.User;
import com.fatmamuge.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository,
                   PasswordEncoder passwordEncoder) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
}

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
   
    public User saveUser(User user) {

    user.setPasswordHash(
            passwordEncoder.encode(user.getPasswordHash())
    );

    return userRepository.save(user);
}

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


    public User updateUser(Integer id, User updatedUser) {

    User user = userRepository.findById(id).orElseThrow();

    user.setNameSurname(updatedUser.getNameSurname());
    user.setPhoneNumber(updatedUser.getPhoneNumber());

    user.setPasswordHash(
            passwordEncoder.encode(updatedUser.getPasswordHash())
    );

    user.setCreatedAt(updatedUser.getCreatedAt());
    user.setRole(updatedUser.getRole());

    return userRepository.save(user);
    }
}
