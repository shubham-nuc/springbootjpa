package com.mycomp.dao.dataservice;

import java.util.List;

import com.mycomp.Model.UserDTO;
import com.mycomp.dao.entity.UserEntity;

public interface IUserDataService {
	
	public List<UserDTO> getAllUsers();

	public String addUser(UserEntity userEntity);

	public String deleteUser(int userId);

	public UserDTO getUsersById(int userId);

	public UserDTO getUsersById(String userName);

}
