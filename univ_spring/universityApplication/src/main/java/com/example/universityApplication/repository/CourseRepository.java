package com.example.universityApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApplication.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
