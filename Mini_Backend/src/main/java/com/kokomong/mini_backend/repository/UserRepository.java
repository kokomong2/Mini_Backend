package com.kokomong.mini_backend.repository;

import com.kokomong.mini_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}