package com.project.expenseTracker.dto.response;

import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.enums.CategoryTypes;
import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private CategoryTypes categoryTypes;
    private String categoryName;
}
