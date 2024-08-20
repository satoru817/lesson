package com.example.universityApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApplication.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}

