package com.petfoster.controllers;

import com.petfoster.modelDTO.UserDTO;
import com.petfoster.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing User operation
 * Handles request related to User management and communicates with the service layer
 */
@RestController
@CrossOrigin//(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * Registers a new user.
     * 
     * @param userDTO the details of the user to register
     * @return ResponseEntity containing the created UserDTO
     */
    // Register a new user
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.signup(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * Updates an existing user profile
     * 
     * @param id the ID of the user to update
     * @param userDTO the updated details of the user profile
     * @return ResponseEntity containing the updated UserDTO
     */
    // Update an existing user profile
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserProfile(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUserProfile(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }
    /**
     * Authenticates a user (Login).
     * 
     * @param userDTO the login credentials of the user
     * @return ResponseEntity containing the authenticated UserDTO
     */
    // Authenticate a user (Login)
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
        UserDTO authenticatedUser = userService.login(userDTO);
        return ResponseEntity.ok(authenticatedUser);
    }
    /**
     * Gets details of a specific user.
     * 
     * @param id the ID of the user to fetch details
     * @return ResponseEntity containing the UserDTO
     */
    // Get details of a specific user
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable Long id) {
        UserDTO userDetails = userService.getUserDetails(id);
        return ResponseEntity.ok(userDetails);
    }
}
