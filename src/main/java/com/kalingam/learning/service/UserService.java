package com.kalingam.learning.service;

import com.kalingam.learning.model.User;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    User getUser(long id);

}
