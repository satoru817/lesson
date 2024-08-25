package com.example.universityApplication.security;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.universityApplication.entity.Login;

public class UserDetailsImpl implements UserDetails{
	private final Login login;
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Login login, Collection<GrantedAuthority> authorities) {
		this.login = login;
		this.authorities = authorities;
	}
	
	public Login getLogin() {
		return login;
	}
	
	@Override
	public String getPassword() {
		return login.getPassword();
	}
	
	
	public String getUsername() {
		return String.valueOf(login.getLoginId());//intからstringにcastすることでgetUsername()を使えるようにしている。
	}
	@Override
	public Collection<?extends GrantedAuthority> getAuthorities(){
		return authorities;//これがよくわからない
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		//return !login.getDeletedAt().equals(null);これはダメだった
		return Objects.isNull(login.getDeletedAt());
	}

}
