package com.jbdl25.minorproject.repositories;

import com.jbdl25.minorproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String user);
}
