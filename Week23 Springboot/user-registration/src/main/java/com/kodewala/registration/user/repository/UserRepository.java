package com.kodewala.registration.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.registration.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
