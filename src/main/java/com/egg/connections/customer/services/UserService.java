package com.egg.connections.customer.services;

import com.egg.connections.customer.repo.UserDAO;
import com.egg.connections.customer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User create(User user){
        return userDAO.save(user);
    }

    public List<User> findAll(){return userDAO.findAll();}
}
