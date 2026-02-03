package com.management.student.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.student.entity.Student;
import com.management.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
     
	private final StudentService studentService;
	
	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student)
	{ 
		studentService.saveStudent(student);
	    return ResponseEntity.ok("Student registered successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id)
	{
		  return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Student> updateStudent( @PathVariable Long id, @RequestBody Student student)
	{
		return ResponseEntity.ok(studentService.updateStudent(id,student));
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
	
	
	
	
}
