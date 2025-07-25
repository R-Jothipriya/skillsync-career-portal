package com.skillsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillsync.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByName(String name);
    User findByEmailAndPassword(String email,String password);  // Or change 'name' to your actual field
}

