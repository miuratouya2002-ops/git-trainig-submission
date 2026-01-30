package com.example.moattravel4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel4.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
