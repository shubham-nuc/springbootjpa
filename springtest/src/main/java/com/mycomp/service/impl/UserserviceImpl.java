package com.mycomp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.Model.UserDTO;
import com.mycomp.dao.dataservice.IUserDataService;
import com.mycomp.dao.entity.UserEntity;
import com.mycomp.service.IUserService;

@Service
public class UserserviceImpl implements IUserService {
	
	@Autowired
	private IUserDataService userDataService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UserDTO> getAllUsers() {
		return userDataService.getAllUsers();
	}

	@Override
	public String addUser(UserDTO user) {
		UserEntity userEntity=modelMapper.map(user, UserEntity.class);
		return userDataService.addUser(userEntity);
	}

	@Override
	public String deleteUser(int userId) {
		return userDataService.deleteUser(userId);
	}

	@Override
	public UserDTO getUsersById(int userId) {
		return userDataService.getUsersById(userId);
	}

	@Override
	public UserDTO getUsersByName(String userName) {
		return userDataService.getUsersById(userName);
	}

}
