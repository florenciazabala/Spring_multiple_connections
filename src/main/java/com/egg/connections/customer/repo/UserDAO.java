package com.egg.connections.customer.repo;

import com.egg.connections.customer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {

}
