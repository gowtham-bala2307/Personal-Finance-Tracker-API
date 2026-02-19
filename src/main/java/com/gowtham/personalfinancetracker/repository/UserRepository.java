package com.gowtham.personalfinancetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowtham.personalfinancetracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

