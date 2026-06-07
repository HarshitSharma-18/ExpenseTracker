package com.project.expenseTracker.mapper;

import com.project.expenseTracker.dto.request.putRequest.ExpenseRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.ExpenseUpdateRequestDTO;
import com.project.expenseTracker.dto.response.ExpenseResponseDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.entity.Expense;
import com.project.expenseTracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public Expense requestDtoToEntity(ExpenseRequestDTO expenseRequestDTO , Category category , User user , Currency currency) {
        Expense expense = new Expense();

        expense.setDescription(expenseRequestDTO.getDescription());

        expense.setAmount(expenseRequestDTO.getAmount());

        expense.setMerchantName(expenseRequestDTO.getMerchantName());

        expense.setExpenseDate(expenseRequestDTO.getExpenseDate());

        expense.setPaymentMethods(expenseRequestDTO.getPaymentMethods());

        expense.setCurrency(currency);

        expense.setNotes(expenseRequestDTO.getNotes());

        expense.setCategory(category);

        expense.setUser(user);

        return expense;
    }

    public ExpenseResponseDTO entityToResponseDto(Expense expense){
        ExpenseResponseDTO expenseResponseDTO = new ExpenseResponseDTO();

        expenseResponseDTO.setId(expense.getId());

        expenseResponseDTO.setCategoryId(expense.getCategory().getId());
        expenseResponseDTO.setCategoryName(expense.getCategory().getCategoryName());
        expenseResponseDTO.setCategoryType(expense.getCategory().getCategoryType());

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

    public Expense updateExpense(ExpenseUpdateRequestDTO expenseUpdateRequestDTO , Expense expense , Category category, Currency currency){
        if(expenseUpdateRequestDTO.getDescription() != null){

            expense.setDescription(expenseUpdateRequestDTO.getDescription());
        }

        if(expenseUpdateRequestDTO.getAmount() != null){

            expense.setAmount(expenseUpdateRequestDTO.getAmount());
        }

        if(expenseUpdateRequestDTO.getMerchantName() != null){

            expense.setMerchantName(expenseUpdateRequestDTO.getMerchantName());
        }

        if(expenseUpdateRequestDTO.getExpenseDate() != null){

            expense.setExpenseDate(expenseUpdateRequestDTO.getExpenseDate());
        }

        if(expenseUpdateRequestDTO.getPaymentMethods() != null){

            expense.setPaymentMethods(expenseUpdateRequestDTO.getPaymentMethods());
        }

        if(expenseUpdateRequestDTO.getNotes() != null){

            expense.setNotes(expenseUpdateRequestDTO.getNotes());
        }

        if(category != null){
            expense.setCategory(category);
        }

        if(currency != null){
            expense.setCurrency(currency);
        }

        return expense;
    }
}
