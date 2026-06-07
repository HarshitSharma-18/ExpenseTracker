package com.project.expenseTracker.service;
import com.project.expenseTracker.dto.request.putRequest.ExpenseRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.ExpenseUpdateRequestDTO;
import com.project.expenseTracker.dto.response.ExpenseResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.entity.Expense;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.ExpenseMapper;
import com.project.expenseTracker.repository.CategoryRepository;
import com.project.expenseTracker.repository.CurrencyRepository;
import com.project.expenseTracker.repository.ExpenseRepository;
import com.project.expenseTracker.repository.UserRepository;
import com.project.expenseTracker.specification.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

    @Autowired
    private CurrencyRepository currencyRepository;

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO expenseRequestDTO){

        User user = userRepository.findById(expenseRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("UserId not found"));

        Category category = categoryRepository.findById(expenseRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("CategoryId not found"));

        if(expenseRequestDTO.getCurrencyId() == null){
            Expense expense = expenseMapper.requestDtoToEntity(expenseRequestDTO , category , user , user.getCurrency());

            return expenseMapper.entityToResponseDto(expense);
        }
        else{
            Currency currency = currencyRepository.findById(expenseRequestDTO.getCurrencyId()).orElseThrow(()->new ResourceNotFoundException("Invalid CurrencyId"));

            Expense expense =  expenseMapper.requestDtoToEntity(expenseRequestDTO , category , user , currency);
            return expenseMapper.entityToResponseDto(expense);
        }
    }

    public List<ExpenseResponseDTO> getAllExpenses(){
        List<Expense> expense = expenseRepository.findAll();
        List<ExpenseResponseDTO> expenseResponseDTOS = new ArrayList<>();

        expense.forEach(expense1 -> {
            expenseResponseDTOS.add(expenseMapper.entityToResponseDto(expense1));
        });

        return expenseResponseDTOS;
    }

    public ExpenseResponseDTO updateExpense(Long expenseId, ExpenseUpdateRequestDTO expenseUpdateRequestDTO) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(()-> new ResourceNotFoundException("Expense with expenseId " + expenseId + " not found"));

        Category category = null;
        Currency currency = null;

        if(expenseUpdateRequestDTO.getCategoryId() != null){
            category = categoryRepository.findById(expenseUpdateRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("Invalid CategoryId"));
        }
        if(expenseUpdateRequestDTO.getCurrencyId() != null){
            currency = currencyRepository.findById(expenseUpdateRequestDTO.getCurrencyId()).orElseThrow(() -> new ResourceNotFoundException("Invalid CurrencyId"));
        }

        Expense updatedExpense = expenseMapper.updateExpense(expenseUpdateRequestDTO , expense , category , currency);

        return expenseMapper.entityToResponseDto(updatedExpense);
    }

    public List<ExpenseResponseDTO> getExpenseBy(List_FilterRequestDTO listFilterRequestDTO){
        Specification<Expense> specification  = Specifications.getSpecification(listFilterRequestDTO);

        List<Expense> listOfExpenseByFilter = expenseRepository.findAll(specification);

        List<ExpenseResponseDTO> listOfExpenseDTOsAfterFilter = new ArrayList<>();

        listOfExpenseByFilter.forEach(expense -> {
            listOfExpenseDTOsAfterFilter.add(expenseMapper.entityToResponseDto(expense));
        });

        return listOfExpenseDTOsAfterFilter;
    }

    public String deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense Id Not Found"));
        expenseRepository.deleteById(expenseId);

        return "Expense is deleted successfully";
    }
}
