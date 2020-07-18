package com.mycomp.dao.dataservice;

import java.util.List;
import java.util.Optional;

import com.mycomp.Model.UserDTO;
import com.mycomp.dao.entity.UserEntity;

public interface IUserDataService {
	
	public Optional<List<UserDTO>> getAllUsers();

	public Optional<UserDTO> addUser(UserDTO userEntity);

	public void deleteUser(Long userId);

	public Optional<UserDTO> getUsersById(Long userId);

	public Optional<UserDTO> getUsersByName(String userName);

	boolean checkUserExistsById(Long userId);

}
