package com.springprogramming.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springprogramming.restapi.entity.Student;
import com.springprogramming.restapi.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;

	// localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> students = repo.findAll();
		return students;
	}

	// localhot:8080/students/1
	@GetMapping("/students/{id}")
	public Student getById(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}

	// localhost:8080/student/add
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addStudent(@RequestBody Student student) {
		repo.save(student);
	}

	// localhost:8080/student/update/{id}
	@PutMapping("student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("Rohiii");
		student.setPercentage(100);
		repo.save(student);
		return student;
	}

	// localhost:8080/student/delete/{id}
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}

}
