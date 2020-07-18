package com.mycomp.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mycomp.Model.AddressDTO;
import com.mycomp.Model.UserDTO;
import com.mycomp.dao.dataservice.IUserDataService;
import com.mycomp.service.IUserService;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserserviceImpl implements IUserService {
	
	@Autowired
	private IUserDataService userDataService;

	@Value("${user.delete.msg}")
	private String deleteMsg;

	@Value("${no.user.msg}")
	private String noUserMsg;

	@Override
	public Optional<List<UserDTO>> getAllUsers() {
		return userDataService.getAllUsers();
	}

	@Override
	public Optional<UserDTO> addUser(UserDTO user) {
		 return userDataService.addUser(user);
	}

	@Override
	public String deleteUser(Long userId) {
		boolean isUserExist = userDataService.checkUserExistsById(userId);
		if (isUserExist) {
			userDataService.deleteUser(userId);
			return deleteMsg;
		}
		return noUserMsg;
	}

	@Override
	public Optional<UserDTO> getUsersById(Long userId) {
		return userDataService.getUsersById(userId);
	}

	@Override
	public Optional<UserDTO> getUsersByName(String userName) {
		return userDataService.getUsersByName(userName);
	}

}
