package com.user.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.user.model.UserPOJO;
import com.user.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userServicesImpl")
    private UserServices userService;

    // Create a new User
    @PostMapping
    public ResponseEntity<UserPOJO> createUser(@Valid @RequestBody UserPOJO userDto) {
        UserPOJO createdUser = userService.createUsers(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<UserPOJO>> getAllUsers() {
        List<UserPOJO> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 if no users found
        }
        return ResponseEntity.ok(users);  // Return 200 with the list of users
    }

    // Get a User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserPOJO> findUserById(@PathVariable("id") int userId) {
        UserPOJO user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();  // 404 if user doesn't exist
        }
        return ResponseEntity.ok(user);  // 200 OK with user details
    }

    // Update a User
    @PutMapping("/{id}")
    public ResponseEntity<UserPOJO> updateUser(@PathVariable("id") int userId, @Valid @RequestBody UserPOJO userDto) {
        UserPOJO updatedUser = userService.updateUsers(userId, userDto);
        return ResponseEntity.ok(updatedUser);  // Return 200 with updated user
    }

    // Delete a User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");  // 200 OK after deletion
    }
}
