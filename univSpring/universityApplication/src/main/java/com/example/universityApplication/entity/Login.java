package com.example.universityApplication.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="logins")
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="login_id")
	private int loginId;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@Column(name="deleted_at" ,insertable = false, updatable = false)
	private Timestamp deletedAt;

}
