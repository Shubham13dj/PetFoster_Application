package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


	boolean existsByEmail(String email);
	
	User findUserByEmail(String email);

}
