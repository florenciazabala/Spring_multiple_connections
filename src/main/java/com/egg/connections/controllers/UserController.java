package com.egg.connections.controllers;

import com.egg.connections.services.UserService;
import com.egg.connections.customer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<User> getAll(){return userService.findAll();}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.create(user);
    }
}
