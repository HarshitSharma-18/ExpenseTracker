package com.project.expenseTracker.controller;

import com.project.expenseTracker.dto.request.CategoryRequestDTO;
import com.project.expenseTracker.dto.response.CategoryResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.create(categoryRequestDTO));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CategoryResponseDTO>> findCategoryBy(@RequestBody List_FilterRequestDTO listFilterRequestDTO) {
        return ResponseEntity.ok(categoryService.getCategoryBy(listFilterRequestDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDTO>> findAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteBudget(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}