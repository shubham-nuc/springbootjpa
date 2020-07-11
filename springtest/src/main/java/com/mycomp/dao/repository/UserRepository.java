package com.mycomp.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycomp.dao.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
