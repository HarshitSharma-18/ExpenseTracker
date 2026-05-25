package com.project.expenseTracker.service;

import com.project.expenseTracker.dto.request.ExpenseRequestDTO;
import com.project.expenseTracker.dto.request.UserRequestDTO;
import com.project.expenseTracker.dto.response.ExpenseResponseDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.Expense;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.ExpenseMapper;
import com.project.expenseTracker.repository.CategoryRepository;
import com.project.expenseTracker.repository.UserRepository;
import org.antlr.v4.runtime.RecognitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseMapper expenseMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO expenseRequestDTO){

        User user = userRepository.findById(expenseRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("UserId not found"));
        Category category = categoryRepository.findById(expenseRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("CategoryId not found"));

        Expense expense = expenseMapper.requestDtoToEntity(expenseRequestDTO , category, user);

        return expenseMapper.entityToResponseDto(expense);
    }
}
