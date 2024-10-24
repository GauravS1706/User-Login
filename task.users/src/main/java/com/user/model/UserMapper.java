package com.user.model;

import org.apache.catalina.User;

public class UserMapper {

	public static UserEntity mapUserEntity(UserPOJO userDto)
	{
		return new  UserEntity (
				userDto.getId(),
				userDto.getName(),
				userDto.getEmail(),
				userDto.getPassword()
				);
	}
	
	public static UserPOJO mapUserDto(UserEntity userEntity)
	{
		return new UserPOJO(
				userEntity.getId(),
				userEntity.getName(),
				userEntity.getEmail(),
				userEntity.getPassword()
				);
	}
	
}
