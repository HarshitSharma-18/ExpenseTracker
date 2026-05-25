package com.project.expenseTracker.mapper;

import com.project.expenseTracker.dto.request.ExpenseRequestDTO;
import com.project.expenseTracker.dto.response.ExpenseResponseDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.Expense;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.repository.ExpenseRepository;
import com.project.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ExpenseMapper {

    @Autowired
    private UserRepository userRepository;

    public Expense requestDtoToEntity(ExpenseRequestDTO expenseRequestDTO , Category category , User user) {
        Expense expense = new Expense();

        expense.setDescription(expenseRequestDTO.getDescription());

        expense.setAmount(expenseRequestDTO.getAmount());

        expense.setMerchantName(expenseRequestDTO.getMerchantName());

        expense.setExpenseDate(expenseRequestDTO.getExpenseDate());

        expense.setPaymentMethods(expenseRequestDTO.getPaymentMethods());

        expense.setCurrency(expenseRequestDTO.getCurrency());

        expense.setNotes(expenseRequestDTO.getNotes());

        expense.setCategory(category);

        expense.setUser(user);

        return expense;
    }

    public ExpenseResponseDTO entityToResponseDto(Expense expense){
        ExpenseResponseDTO expenseResponseDTO = new ExpenseResponseDTO();

        expenseResponseDTO.setId(expense.getId());

        expenseResponseDTO.setCategoryName(expense.getCategory().getCategoryName());

        expenseResponseDTO.setDescription(expense.getDescription());

        expenseResponseDTO.setAmount(expense.getAmount());

        expenseResponseDTO.setMerchantName(expense.getMerchantName());

        expenseResponseDTO.setTransactionDate(expense.getExpenseDate());

        expenseResponseDTO.setPaymentMethod(expense.getPaymentMethods());

        expenseResponseDTO.setCurrency(expense.getCurrency());

        expenseResponseDTO.setRecordDateAndTime(expense.getCreatedAt());

        expenseResponseDTO.setNotes(expense.getNotes());

        return expenseResponseDTO;
    }

    public Expense updateEntityFromDto(ExpenseRequestDTO expenseRequestDTO , Expense expense){
        if(expenseRequestDTO.getUserId() != null){
            expense.setUser(userRepository.findById(expenseRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("UserId not found")));
        }
        return expense;
    }
}
