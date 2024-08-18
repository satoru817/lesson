package com.example.universityApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="teachers")
@Data
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//IDENTITY列はauto_incrementを指定した列のこと？
	@Column(name="teacher_id")
	private Integer teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	

}
