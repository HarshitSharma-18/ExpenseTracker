package com.project.expenseTracker.service;

import com.project.expenseTracker.dto.request.UserRequestDTO;
import com.project.expenseTracker.dto.response.UserResponseDTO;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.UserMapper;
import com.project.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO createNewUser(UserRequestDTO userRequestDTO){
        User newUser = userMapper.requestDtoToEntity(userRequestDTO);

        userRepository.save(newUser);

        return userMapper.entityToResponseDto(newUser);
    }

    public UserResponseDTO getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + "not found"));
        return userMapper.entityToResponseDto(user);
    }

    public List<UserResponseDTO> getAllUsers(){
        List<User> listOfUsers = userRepository.findAll();

        List<UserResponseDTO> listOfResponseUser = new ArrayList<>();

        listOfUsers.forEach(user -> {
           listOfResponseUser.add(userMapper.entityToResponseDto(user));
        });

        return listOfResponseUser;
    }

    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO , Long userId){
       User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with ID " + userId + "not found"));
       User updatedUser = userMapper.updateEntityFromDto(userRequestDTO , user);

       return userMapper.entityToResponseDto(updatedUser);
    }

    public String deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + "not found"));

        userRepository.deleteById(userId);
        return "User deleted successfully with ID " + userId;
    }
}
