package com.kalingam.learning.service.impl;

import com.kalingam.learning.model.User;
import com.kalingam.learning.repository.UserRepository;
import com.kalingam.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        User userDB = userRepository.save(user);
        if(userDB != null) return userDB;
        return null;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getUserId());
        if(userOptional.isPresent()){
            User userDB = userOptional.get();
            userDB.setAge(user.getAge());
            userDB.setEmail(user.getEmail());
            userDB.setFirstName(user.getFirstName());
            userDB.setLastName(user.getLastName());
            return userRepository.save(userDB);
        }
        return null;
    }

    @Override
    public User getUser(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) return userOptional.get();
        return null;
    }
}
