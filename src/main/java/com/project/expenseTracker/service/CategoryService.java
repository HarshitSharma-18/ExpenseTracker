package com.project.expenseTracker.service;

import com.project.expenseTracker.dto.request.putRequest.CategoryRequestDTO;
import com.project.expenseTracker.dto.response.CategoryResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.CategoryMapper;
import com.project.expenseTracker.repository.CategoryRepository;
import com.project.expenseTracker.repository.UserRepository;
import com.project.expenseTracker.specification.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private UserRepository userRepository;

    public CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO){

        User user = userRepository.findById(categoryRequestDTO.getUser_id()).orElseThrow(()-> new ResourceNotFoundException("Invalid UserId please, please Give Valid User id"));

        Category newCategory =categoryMapper.requestDtoToEntity(categoryRequestDTO , user);

        categoryRepository.save(newCategory);

        return categoryMapper.entityToResponseDto(newCategory);
    }

    public List<CategoryResponseDTO> getCategoryBy(List_FilterRequestDTO listFilterRequestDTO){
        Specification<Category> specifications = Specifications.getSpecification(listFilterRequestDTO);

        List<Category> categoryList = categoryRepository.findAll(specifications);

        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        categoryList.forEach(category -> {
            categoryResponseDTOS.add(categoryMapper.entityToResponseDto(category));
        });

        return categoryResponseDTOS;
    }

    public List<CategoryResponseDTO> getAllCategory(){
        List<Category> categoriesList = categoryRepository.findAll();

        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();

        categoriesList.forEach(category -> {
            categoryResponseDTOS.add(categoryMapper.entityToResponseDto(category));
        });

        return categoryResponseDTOS;
    }

    public String deleteCategory(Long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Invalid CategoryId , please give valid categoryId"));

        categoryRepository.delete(category);

        return "Category Deleted Successfully";
    }
}
