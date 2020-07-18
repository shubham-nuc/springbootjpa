package com.mycomp.Model;

import java.util.ArrayList;
import java.util.List;

import com.mycomp.dao.entity.AddressEntity;

import lombok.Data;

@Data
public class UserDTO {
	
	private long id;
	private String name;
	private int age;
	
	protected List<AddressDTO> addressList;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<AddressDTO> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressDTO> addressList) {
		this.addressList = addressList;
	}

}
