package com.project.expenseTracker.dto.response;

import com.project.expenseTracker.entity.Currency;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    private Currency currency;
}
