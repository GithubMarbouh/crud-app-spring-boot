package com.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail( String email);


}
