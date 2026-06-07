package com.project.expenseTracker.dto.request.updateRequest;

import lombok.Data;

@Data
public class UserUpdateRequestDTO {
    private String username;
    private Long currencyId;
}
