package com.example.universityApplication.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.universityApplication.entity.Login;
import com.example.universityApplication.repository.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	private final LoginRepository loginRepository;
	
	public UserDetailsServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException{
		try {
			Login login = loginRepository.findByLoginId(Integer.valueOf(loginId));
			
			String userRoleName = login.getRole().getName();
			
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			
			authorities.add(new SimpleGrantedAuthority(userRoleName));
			
			return new UserDetailsImpl(login, authorities);
		}catch(Exception e) {
			throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
		}
	}

}
