package com.humber.Week8SpringSecurityApp.repositories;

import com.humber.Week8SpringSecurityApp.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser,Long> {
// get user by username

    public Optional<MyUser> findByUsername(String username);
}
