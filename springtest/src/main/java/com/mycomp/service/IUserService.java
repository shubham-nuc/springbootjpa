package com.mycomp.service;

import java.util.List;

import com.mycomp.Model.UserDTO;

public interface IUserService {
	
	public List<UserDTO> getAllUsers();

	public String addUser(UserDTO user);

	public String deleteUser(int userId);

	public UserDTO getUsersByName(String userName);

	public UserDTO getUsersById(int userId);

}
