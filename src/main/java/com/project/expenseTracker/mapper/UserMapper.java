package com.project.expenseTracker.mapper;

import com.project.expenseTracker.dto.request.UserRequestDTO;
import com.project.expenseTracker.dto.response.UserResponseDTO;
import com.project.expenseTracker.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserMapper {

    public User requestDtoToEntity(UserRequestDTO userRequestDTO){
        User user = new User();

        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setCurrency(userRequestDTO.getCurrency());

        return user;
    }

    public UserResponseDTO entityToResponseDto(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setCurrency(user.getCurrency());

        return userResponseDTO;
    }

    public User updateEntityFromDto(UserRequestDTO userRequestDTO, User user){

        if (userRequestDTO.getUsername() != null) {
            user.setUsername(userRequestDTO.getUsername());
        }

        if (userRequestDTO.getEmail() != null) {
            user.setEmail(userRequestDTO.getEmail());
        }

        if (userRequestDTO.getPassword() != null) {
            user.setPassword(userRequestDTO.getPassword());
        }

        if (userRequestDTO.getCurrency() != null) {
            user.setCurrency(userRequestDTO.getCurrency());
        }

        return user;
    }
}
