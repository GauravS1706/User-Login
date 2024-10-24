package com.user.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.UserPOJO;
import com.user.model.UserEntity;
import com.user.model.UserMapper;
import com.user.repository.UsersRepo;
import com.user.services.vaditor.ResourceNotFoundException;

@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UsersRepo userRepo;
	@Override
	public UserPOJO createUsers(UserPOJO userDto) {
		UserEntity user= UserMapper.mapUserEntity(userDto);
		UserEntity createUser=userRepo.save(user);
		return UserMapper.mapUserDto(createUser);
	}

	@Override
	public UserPOJO getUserById(int userId) {
		UserEntity user=userRepo.findById(userId).
				orElseThrow(
						()-> new ResourceNotFoundException("User does not exists with given Id "+userId)
						);
		return UserMapper.mapUserDto(user);
	}

	@Override
	public List<UserPOJO> getAllUsers() {
		List<UserEntity> user= userRepo.findAll();
		return user.stream().map((users)->UserMapper.mapUserDto(users)).collect(Collectors.toList());
		
	}

	@Override
	public void deleteUser(int userId) {
		UserEntity user=userRepo.findById(userId).
				orElseThrow(
						()-> new ResourceNotFoundException("User does not exists with given Id "+userId)
						);
			userRepo.deleteById(userId);
		
	}

	@Override
	public UserPOJO updateUsers(int userId, UserPOJO updateUser) {
		UserEntity user=userRepo.findById(userId).
				orElseThrow(
						()-> new ResourceNotFoundException("User does not exists with given Id "+userId)
						);
		user.setName(updateUser.getName());
		user.setEmail(updateUser.getEmail());
		user.setPassword(updateUser.getPassword());
		UserEntity update=userRepo.save(user);
		return UserMapper.mapUserDto(update);
	}

}
