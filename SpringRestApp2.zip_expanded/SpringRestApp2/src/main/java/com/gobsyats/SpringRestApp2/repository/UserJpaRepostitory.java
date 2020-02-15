package com.gobsyats.SpringRestApp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.gobsyats.SpringRestApp2.model.Users;

@Component
public interface UserJpaRepostitory extends JpaRepository<Users, Long> {

	Users findByName(String name);
	
}
