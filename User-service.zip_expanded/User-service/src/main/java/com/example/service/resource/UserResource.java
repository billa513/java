package com.example.service.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.Repository.UserRepository;
import com.example.service.bean.User;

@RestController
@RequestMapping("/api")
public class UserResource {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	//mormal method
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userRepository.findById(id);
	}

	/*
	 * with Entity class
	 * 
	 * @GetMapping("/users/{id}") public ResponseEntity<Optional<User>>
	 * getUserById1(@PathVariable Long id) { Optional<User> user
	 * =userRepository.findById(id); return new
	 * ResponseEntity<>(user,HttpStatus.FOUND); }
	 */
	@GetMapping("/address/{address}")
	public Optional<User> getUserByAddress(@PathVariable String address){
		return userRepository.findByAddress(address);
	}
	@GetMapping("/delete/{id}")
	public void deleteBy(@PathVariable Long id) {
		userRepository.deleteById(id);
	} 
	@PostMapping("/addusers")
	public User createUser(@RequestBody User user) {
		User savedUser= userRepository.save(user);
		return savedUser;
	}
}
