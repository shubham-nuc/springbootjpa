package com.mycomp.dao.dataservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.mycomp.Model.User;

@Service
public class UserDataServiceImpl implements IUserDataService {
	
	public UserDataServiceImpl() {
		User user1=new User();
		user1.setId(1);
		user1.setName("Shubham");
		user1.setAge(30);
		user1.setCity("Chhachhrauli");
		
		User user2=new User();
		user2.setId(2);
		user2.setName("Kunal");
		user2.setAge(32);
		user2.setCity("Amritsar");
		
		users.add(user1);
		users.add(user2);
	}

	List<User> users=new ArrayList<>();
	@Override
	public List<User> getAllUsers() {
		return users;
	}
	@Override
	public String addUser(User user) {
		this.users.add(user);
		return "User Added Successully.";
	}
	@Override
	public String deleteUser(int userId) {
		String message="No User Found";
		ListIterator<User> itr=users.listIterator();
		while(itr.hasNext()) {
			User user=(User) itr.next();
			int id= user.getId();
			if(id==userId) {
				users.remove(user);
				message="User Deleted Successully";
				break;
			}
		}
		return message;
	}
	@Override
	public User getUsersById(int userId) {
		ListIterator<User> itr=users.listIterator();
		while(itr.hasNext()) {
			User user=(User) itr.next();
			int id= user.getId();
			if(id==userId) {
				return user;
			}
		}
		return null;
	}
	@Override
	public User getUsersById(String userName) {
		ListIterator<User> itr=users.listIterator();
		while(itr.hasNext()) {
			User user=(User) itr.next();
			String name= user.getName();
			if(userName.equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

}
