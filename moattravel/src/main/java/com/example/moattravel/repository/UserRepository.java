package com.example.moattravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravelApplication;.entity.User;

public interface UserRepository {

	public interface UserRepository extends JpaRepository<User, Integer> {

	}

}
