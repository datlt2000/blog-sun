package com.codekisu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.codekisu.data.User;
import com.codekisu.repository.UserRepository;

/**
 * 
 * @author super
 * create database
 */
//@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	/*
    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;
    */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Admin account
    	/*
        if (userRepository.findByName("superteen0") == null) {
            User admin = new User();
            admin.setName("superteen0");
            admin.setEmail("dat.lt183493@sis.hust.edu.vn");
            admin.setPass(passwordEncoder.encode("Dat11011000"));
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findByName("dat.lt") == null) {
            User user = new User();
            user.setName("dat.lt");
            user.setEmail("letrongdat20@gmail.com");
            user.setPass(passwordEncoder.encode("123456"));
            user.setRole("ROLE_MEMBER");
            userRepository.save(user);
        }
       */
    }

}