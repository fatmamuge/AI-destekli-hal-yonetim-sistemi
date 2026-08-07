package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.User;
import com.fatmamuge.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    public User updateUser(Integer id, User updatedUser) {
    User user = userRepository.findById(id).orElseThrow();

        user.setNameSurname(updatedUser.getNameSurname());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setPasswordHash(updatedUser.getPasswordHash());
        user.setCreatedAt(updatedUser.getCreatedAt());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }
}
