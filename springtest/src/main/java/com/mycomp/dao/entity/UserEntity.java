package com.mycomp.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SG_USERS")
public class UserEntity {
	@Id
	@Column(name= "USER_ID")
	private long id;
	
	@Column(name= "USER_NAME")
	private String name;
	
	@Column(name= "USER_CITY")
	private String city;
	
	@Column(name= "USER_AGE")
	private int age;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
