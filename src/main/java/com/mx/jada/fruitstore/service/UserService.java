package com.mx.jada.fruitstore.service;

import java.util.List;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.jada.fruitstore.product.dao.IUserDao;
import com.mx.jada.fruitstore.products.entity.Users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



/**
 * 
 * @author jada
 * UserDetailsService es clase propia sprig core
 */
@Service
public class UserService implements UserDetailsService{
	
	
	@Autowired
	IUserDao userDao;
	
	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users us=userDao.findByUsername(username);
		
		if (us==null) {
			log.error("No existe usuario en el sistema"+username);
			
			throw new UsernameNotFoundException("No existe usuario en el sistema"+username); 
		}
		
		List<GrantedAuthority>authorities=us.getRoles().
				stream().map(role->new SimpleGrantedAuthority(role.getAuthority())).
				collect(Collectors.toList());
		
		return new User(us.getUsername(),us.getPassword(),us.getEnabled(),true,true,true,authorities);
	}
	

}
