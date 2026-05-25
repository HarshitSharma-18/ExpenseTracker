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
import com.project.expenseTracker.repository.ExpenseRepository;
import com.project.expenseTracker.repository.UserRepository;
import org.antlr.v4.runtime.RecognitionException;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseMapper expenseMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO expenseRequestDTO){

        User user = userRepository.findById(expenseRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("UserId not found"));
        Category category = categoryRepository.findById(expenseRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("CategoryId not found"));

        Expense expense = expenseMapper.requestDtoToEntity(expenseRequestDTO , category, user);

        return expenseMapper.entityToResponseDto(expense);
    }

    public List<ExpenseResponseDTO> getAllExpenses(){
        List<Expense> expense = expenseRepository.findAll();
        List<ExpenseResponseDTO> expenseResponseDTOS = new ArrayList<>();

        expense.forEach(expense1 -> {
            expenseResponseDTOS.add(expenseMapper.entityToResponseDto(expense1));
        });

        return expenseResponseDTOS;
    }

    public ExpenseResponseDTO updateExpense(Long expenseId, ExpenseRequestDTO expenseRequestDTO) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(()-> new ResourceNotFoundException("Expense with expenseId " + expenseId + " not found"));

        Expense expense1 = expenseMapper.updateEntityFromDto(expenseRequestDTO , expense);
        return expenseMapper.entityToResponseDto(expense);
    }
}
