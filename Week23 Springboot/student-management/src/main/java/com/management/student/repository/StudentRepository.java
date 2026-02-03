package com.management.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
