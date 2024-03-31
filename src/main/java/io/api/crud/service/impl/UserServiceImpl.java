package io.api.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.api.crud.dto.UserDTO;
import io.api.crud.entity.User;
import io.api.crud.repository.UserRepository;
import io.api.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		
		userRepository.save(user);
		
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer id) {
		User user = userRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário inválido id " + id));
		return user;
	}

	@Override
	public void updateUser(Integer id, User user) {
			userRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário inválido id" + id));
			
			user.setId(id);
			userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = userRepository
			.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário inválido id" + id));
		userRepository.delete(user);
	}

	@Override
	public void updateName(Integer id, UserDTO userDTO) {
		User user = userRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário inválido id" + id));
		
		user.setName(userDTO.getName());
		userRepository.save(user);
	}

	
	
}
