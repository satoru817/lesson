package com.example.universityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
