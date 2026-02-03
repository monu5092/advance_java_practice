package com.kodewala.birthdaywishes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.birthdaywishes.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByDob(LocalDate dob);

}
