package com.example.universityApp.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="courses")
@Data
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private Integer courseId;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	
	@Column(name="max_students_num")
	private String maxStudentsNum;
	
	@Column(name="period_begin")
	private Date periodBegin;
	
	@Column(name="period_end")
	private Date periodEnd;
}
