package com.project.expenseTracker.service;

import com.project.expenseTracker.dto.request.putRequest.UserRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.UserUpdateRequestDTO;
import com.project.expenseTracker.dto.response.UserResponseDTO;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceAlreadyExistsException;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.UserMapper;
import com.project.expenseTracker.repository.CurrencyRepository;
import com.project.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    public UserResponseDTO createNewUser(UserRequestDTO userRequestDTO){
        if(userRepository.existsByEmail(userRequestDTO.getEmail())){
            throw new ResourceAlreadyExistsException("Email ID already exist , Please Sign_up with another Email");
        }

        Currency currency = null;

        if(userRequestDTO.getCurrencyId() != null){
            currency = currencyRepository.findById(userRequestDTO.getCurrencyId()).orElseThrow(()->new ResourceNotFoundException("Invalid CurrencyId"));
        }

        User newUser = userMapper.requestDtoToEntity(userRequestDTO , currency);

        //settingUsername as user if the username is null
        if(userRequestDTO.getUsername() == null){
            newUser.setUsername("User");
        }

        userRepository.save(newUser);

        return userMapper.entityToResponseDto(newUser);
    }

    public UserResponseDTO getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
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

    public UserResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO , Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with ID " + userId + "not found"));

        Currency currency = null;
        if(userUpdateRequestDTO.getCurrencyId() != null){
            currency = currencyRepository.findById(userUpdateRequestDTO.getCurrencyId()).orElseThrow(()-> new ResourceNotFoundException("Invalid CurrencyId"));
        }

        User updatedUser = userMapper.updateUser(userUpdateRequestDTO, user , currency);

       return userMapper.entityToResponseDto(updatedUser);
    }

    public String deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + "not found"));

        userRepository.deleteById(userId);
        return "User deleted successfully with ID " + userId;
    }
}
