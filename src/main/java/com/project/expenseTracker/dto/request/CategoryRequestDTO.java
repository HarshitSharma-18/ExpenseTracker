package com.project.expenseTracker.dto.request;

import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.enums.CategoryTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequestDTO {
    @NotNull
    private Long user_id;

    @NotNull
    private Category category;
}
