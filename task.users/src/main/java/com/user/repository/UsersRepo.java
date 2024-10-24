package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.UserEntity;

public interface UsersRepo extends JpaRepository<UserEntity, Integer>{

}
