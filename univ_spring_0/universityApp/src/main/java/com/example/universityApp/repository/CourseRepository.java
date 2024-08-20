package com.example.universityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApp.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
