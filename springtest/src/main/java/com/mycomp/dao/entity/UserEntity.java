package com.mycomp.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SG_USERS")
//@SequenceGenerator(name="mySeq", initialValue=12, allocationSize=100)  // used to create custom sequence, can create directly in DB also
public class UserEntity {
	@Id
	@Column(name= "USER_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)  //One Global sequence generator for all tables
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mySeq") //For user defined sequence
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //Individual sequence generator per entity/table
	private long id;
	
	@Column(name= "USER_NAME")
	private String name;
	
	@Column(name= "USER_AGE")
	private int age;
	
	//For UniDirectional relationship
	/*@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private List<AddressEntity> addressList = new ArrayList<>();*/
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval=true)
	//@OrderBy  // to get all address order by  primary key 
	@OrderBy("pincode desc")   // to get all address order by  desc 
	private List<AddressEntity> addressList = new ArrayList<>();
	

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

	public List<AddressEntity> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressEntity> addressList) {
		this.addressList = addressList;
		//important for bidirectional relationship
		addressList.stream().forEach(add->add.setUser(this));
	}
}
