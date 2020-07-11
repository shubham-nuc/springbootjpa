package com.mycomp.dao.dataservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycomp.Model.UserDTO;
import com.mycomp.dao.entity.UserEntity;
import com.mycomp.dao.repository.UserRepository;

@Service
public class UserDataServiceImpl implements IUserDataService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${user.success.msg}")
	private String successMsg;
	
	@Value("${user.delete.msg}")
	private String deleteMsg;
	
	@Value("${no.user.msg}")
	private String noUserMsg;

	List<UserDTO> users=new ArrayList<>();
	@Override
	public List<UserDTO> getAllUsers() {
		return users;
	}
	@Override
	public String addUser(UserEntity user) {
		userRepository.save(user);
		return successMsg;
	}
	@Override
	public String deleteUser(int userId) {
		String message=noUserMsg;
		ListIterator<UserDTO> itr=users.listIterator();
		while(itr.hasNext()) {
			UserDTO user=(UserDTO) itr.next();
			int id= user.getId();
			if(id==userId) {
				users.remove(user);
				message=deleteMsg;
				break;
			}
		}
		return message;
	}
	@Override
	public UserDTO getUsersById(int userId) {
		ListIterator<UserDTO> itr=users.listIterator();
		while(itr.hasNext()) {
			UserDTO user=(UserDTO) itr.next();
			int id= user.getId();
			if(id==userId) {
				return user;
			}
		}
		return null;
	}
	@Override
	public UserDTO getUsersById(String userName) {
		ListIterator<UserDTO> itr=users.listIterator();
		while(itr.hasNext()) {
			UserDTO user=(UserDTO) itr.next();
			String name= user.getName();
			if(userName.equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

}
