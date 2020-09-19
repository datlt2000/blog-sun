package com.codekisu.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codekisu.data.User;
import com.codekisu.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	/**
	 * User service
	 * get data
	 */
	public User findUserById(long id) {
		return userRepository.findById(id);
	}
	public User findUserBySignature(String signature) {
		return userRepository.findBySignature(signature);
	}
	public User findUserByName(String name) {
		return userRepository.findByName(name);
	}
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	/**
	 * save user
	 * @param user
	 */
	public void saveUser(User user) {
		this.userRepository.save(user);
	}
	/**
	 * check user authorities
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByName(userName);
		System.out.println(userName);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		String role = user.getRole();
		grantedAuthorities.add(new SimpleGrantedAuthority(role));
		return new org.springframework.security.core.userdetails.User(
                user.getName(), user.getPass(), grantedAuthorities);
	}
}
