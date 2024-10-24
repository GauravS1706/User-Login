package com.user.services;

import java.util.List;

import com.user.model.UserPOJO;

public interface UserServices {

	UserPOJO createUsers(UserPOJO userDto);

    UserPOJO getUserById(int userId);

    List<UserPOJO> getAllUsers();

    void  deleteUser(int userId);

    UserPOJO  updateUsers(int userId, UserPOJO updateUser);
}
