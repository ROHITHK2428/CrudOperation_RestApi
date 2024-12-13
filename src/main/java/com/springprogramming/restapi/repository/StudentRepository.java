package com.springprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprogramming.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
