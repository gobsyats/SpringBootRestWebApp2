package com.gobsyats.SpringRestApp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gobsyats.SpringRestApp2.model.Users;
import com.gobsyats.SpringRestApp2.repository.UserJpaRepostitory;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserJpaRepostitory userJpaRepository;
	
	@GetMapping("/all")
	public List<Users> findAll(){
		return userJpaRepository.findAll();
	}
	
	@GetMapping(value="/{name}")
	public Users getUser(@PathVariable String name) {
		return userJpaRepository.findByName(name);
	}
	
	@PostMapping(value = "/load")
	public Users load(@RequestBody Users users) {
		userJpaRepository.save(users);
		return userJpaRepository.findByName(users.getName());
	}
	

}
