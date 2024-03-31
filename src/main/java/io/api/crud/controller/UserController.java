package io.api.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.api.crud.dto.UserDTO;
import io.api.crud.entity.User;
import io.api.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		
		return "Success";
	}
	
	@GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/get")
	public User getUser(@RequestParam Integer id) {
			return userService.getUser(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user){
		userService.updateUser(id, user);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/update-name/{id}")
	public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody UserDTO userDTO){
		userService.updateName(id, userDTO);
		return ResponseEntity.noContent().build();
	}
	
	
}
