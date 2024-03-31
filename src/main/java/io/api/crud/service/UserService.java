package io.api.crud.service;


import java.util.List;

import io.api.crud.dto.UserDTO;
import io.api.crud.entity.User;

public interface UserService {

	void addUser(User user);
	
	List<User> getUsers();
	
	User getUser(Integer id);
	
	void updateUser(Integer id, User user);
	
	void deleteUser(Integer id);
	
	void updateName(Integer id, UserDTO userDTO);
}
