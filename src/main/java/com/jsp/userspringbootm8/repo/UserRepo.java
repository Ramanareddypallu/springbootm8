package com.jsp.userspringbootm8.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.userspringbootm8.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
