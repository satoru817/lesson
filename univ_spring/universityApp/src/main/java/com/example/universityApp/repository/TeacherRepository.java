package com.example.universityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApp.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

}
