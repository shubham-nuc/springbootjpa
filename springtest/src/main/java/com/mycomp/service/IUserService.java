package com.mycomp.service;

import java.util.List;
import java.util.Optional;

import com.mycomp.Model.UserDTO;

public interface IUserService {
	
	public Optional<List<UserDTO>> getAllUsers();

	public Optional<UserDTO> addUser(UserDTO user);

	public String deleteUser(Long userId);

	public Optional<UserDTO> getUsersByName(String userName);

	public Optional<UserDTO> getUsersById(Long userId);

}
