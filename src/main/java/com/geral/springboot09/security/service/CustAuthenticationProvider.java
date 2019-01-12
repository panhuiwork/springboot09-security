package com.geral.springboot09.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.geral.springboot09.security.service.entity.DataUser;
import com.geral.springboot09.security.service.entity.User;

@Service
public class CustAuthenticationProvider implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = DataUser.getUser(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("添加權限");
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getQx()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getUserpass(), authorities);
	}

}
