package com.project.expenseTracker.mapper;

import com.project.expenseTracker.dto.request.putRequest.CategoryRequestDTO;
import com.project.expenseTracker.dto.response.CategoryResponseDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category requestDtoToEntity(CategoryRequestDTO categoryRequestDTO , User user){
        Category category = new Category();

        category.setUser(user);
        category.setCategoryType(categoryRequestDTO.getCategoryTypes());
        category.setCategoryName(category.getCategoryName());

        return category;
    }

    public CategoryResponseDTO entityToResponseDto(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

        categoryResponseDTO.setId(category.getId());
        categoryResponseDTO.setCategoryTypes(category.getCategoryType());
        categoryResponseDTO.setCategoryName(category.getCategoryName());

        return categoryResponseDTO;
    }
}
