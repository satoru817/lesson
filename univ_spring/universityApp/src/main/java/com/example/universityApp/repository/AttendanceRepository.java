package com.example.universityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApp.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{

}
