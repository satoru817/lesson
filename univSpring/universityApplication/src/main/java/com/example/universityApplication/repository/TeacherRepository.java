package com.example.universityApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApplication.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

}
