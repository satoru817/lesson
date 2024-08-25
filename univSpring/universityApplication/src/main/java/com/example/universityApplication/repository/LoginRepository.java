package com.example.universityApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universityApplication.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	public Login findByLoginId(Integer loginId );//Byは大文字
}
