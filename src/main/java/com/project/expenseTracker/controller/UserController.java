package com.project.expenseTracker.controller;

import com.project.expenseTracker.dto.request.UserRequestDTO;
import com.project.expenseTracker.dto.response.UserResponseDTO;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.service.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createNewUser(userRequestDTO));
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        return ResponseEntity
                .ok(userService.getUser(userId));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody UserRequestDTO userRequestDTO , @PathVariable Long userId) {
        return ResponseEntity
                .ok(userService.updateUser(userRequestDTO, userId));
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.
                ok(userService.deleteUser(userId));
    }
}
