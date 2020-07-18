package com.mycomp.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycomp.dao.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByName(String userName);
	Optional<UserEntity> findByNameIgnoreCase(String userName);

}
