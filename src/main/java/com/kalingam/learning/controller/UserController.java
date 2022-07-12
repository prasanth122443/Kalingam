package com.kalingam.learning.controller;

import com.kalingam.learning.model.User;
import com.kalingam.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User userDB = userService.addUser(user);
        if(userDB == null)
            return new ResponseEntity<>("Unable to Save Object to DB", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(userDB, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<Object> updateUser(@RequestBody User user){
        User userDB = userService.updateUser(user);
        if(userDB == null)
            return new ResponseEntity<>("Unable to Update user to DB", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(userDB, HttpStatus.NO_CONTENT);
    }


    @GetMapping("/user")
    public ResponseEntity<Object> findUser(@RequestParam("id") long id){
        User userDB = userService.getUser(id);
        if(userDB == null)
            return new ResponseEntity<>("Unable to find User", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userDB, HttpStatus.OK);
    }
}
