package com.petfoster.controllers;

import com.petfoster.modelDTO.UserDTO;
import com.petfoster.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.addNewUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    // Update an existing user profile
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserProfile(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUserProfile(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    // Authenticate a user (Login)
    @PostMapping("/login")
    public ResponseEntity<UserDTO> authenticateUser(@RequestParam String email, @RequestParam String password) {
        UserDTO authenticatedUser = userService.authenticateUser(email, password);
        return ResponseEntity.ok(authenticatedUser);
    }

    // Get details of a specific user
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable Long id) {
        UserDTO userDetails = userService.getUserDetails(id);
        return ResponseEntity.ok(userDetails);
    }
}
