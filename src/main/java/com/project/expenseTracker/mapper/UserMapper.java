package com.project.expenseTracker.mapper;

import com.project.expenseTracker.dto.request.putRequest.UserRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.UserUpdateRequestDTO;
import com.project.expenseTracker.dto.response.UserResponseDTO;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User requestDtoToEntity(UserRequestDTO userRequestDTO , Currency currency){
        User user = new User();

        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setCurrency(currency);

        return user;
    }

    public UserResponseDTO entityToResponseDto(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setCurrency(user.getCurrency());
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setLastUpdatedAt(user.getUpdatedAt());

        return userResponseDTO;
    }

    public User updateUser(UserUpdateRequestDTO userUpdateRequestDTO, User user , Currency currency){

        if (userUpdateRequestDTO.getUsername() != null) {
            user.setUsername(userUpdateRequestDTO.getUsername());
        }

        if (currency != null) {
            user.setCurrency(currency);
        }

        return user;
    }
}
