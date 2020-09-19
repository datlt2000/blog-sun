package com.codekisu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codekisu.data.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findById(long id);
	User findBySignature(String signature);
	User findByName(String name);
	User findByEmail(String email);
}
