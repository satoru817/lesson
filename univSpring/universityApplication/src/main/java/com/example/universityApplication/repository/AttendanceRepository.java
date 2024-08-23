package com.example.universityApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApplication.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{


	List<Attendance> findByCourseCourseId(Integer courseId);



}
