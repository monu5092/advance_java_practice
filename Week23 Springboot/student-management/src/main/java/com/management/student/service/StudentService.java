package com.management.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.student.entity.Student;
import com.management.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id)
	{
		return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found with this "+id));
	}
	
	public Student updateStudent(Long id,Student student)
	{
		Student existing = getStudentById(id);
		existing.setName(student.getName());
		existing.setEmail(student.getName());
	    return studentRepository.save(existing);
	}
	
	 public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }

}
