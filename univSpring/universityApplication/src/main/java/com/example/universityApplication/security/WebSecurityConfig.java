package com.example.universityApplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity//Spring Securityを有効にする設定
@EnableMethodSecurity
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		
		.authorizeHttpRequests((requests)->requests
				.requestMatchers("/css/**").permitAll()
				.anyRequest().authenticated()
		)
		
		.formLogin((form)->form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/admin/univ?loggedIn")
				.failureUrl("/login?error")
				.permitAll()
				);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
