package com.project.expenseTracker.service;

import com.project.expenseTracker.dto.request.BudgetRequestDTO;
import com.project.expenseTracker.dto.response.BudgetResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.entity.Budget;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.BudgetMapper;
import com.project.expenseTracker.repository.BudgetRepository;
import com.project.expenseTracker.repository.CategoryRepository;
import com.project.expenseTracker.repository.UserRepository;
import com.project.expenseTracker.specification.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetMapper budgetMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public BudgetResponseDTO createBudget(BudgetRequestDTO budgetRequestDTO){

        Category category = categoryRepository.findById(budgetRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("Invalid Category Id , please give valid Category"));
        User user = userRepository.findById(budgetRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Invalid UserId , Please provide valid UserId"));
        Budget newBudget = budgetMapper.requestDtoToEntity(budgetRequestDTO , category , user);

        budgetRepository.save(newBudget);

        return budgetMapper.entityToResponseDto(newBudget);
    }

    public List<BudgetResponseDTO> getBudgetBy(List_FilterRequestDTO listFilterRequestDTO){
        Specification<Budget> specification = Specifications.getSpecification(listFilterRequestDTO);

        List<Budget> listOfBudget = budgetRepository.findAll(specification);

        List<BudgetResponseDTO> listOfBudgetResponse  = new ArrayList<>();

        listOfBudget.forEach(budget -> {
            listOfBudgetResponse.add(budgetMapper.entityToResponseDto(budget));
        });

        return listOfBudgetResponse;
    }

    public List<BudgetResponseDTO> getAllBudget() {
        List<Budget> budgets = budgetRepository.findAll();

        List<BudgetResponseDTO> budgetResponseDTOList = new ArrayList<>();

        budgets.forEach(budget -> {
            budgetResponseDTOList.add(budgetMapper.entityToResponseDto(budget));
        });

        return budgetResponseDTOList;
    }

    public BudgetResponseDTO updateBudget(Long budgetId , BudgetRequestDTO budgetRequestDTO) {
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(() -> new ResourceNotFoundException("Invalid budgetId , please provide valid budgetId"));

        if (budgetRequestDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(budgetRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("Invalid CategoryId , please provide valid CategoryId"));
            Budget updatedBudget = budgetMapper.updateEntityFromDto(budgetRequestDTO, budget , category);
            return budgetMapper.entityToResponseDto(updatedBudget);
        }
        else{
            Budget updatedBudget = budgetMapper.updateEntityFromDto(budgetRequestDTO ,budget, null);
            return budgetMapper.entityToResponseDto(updatedBudget);
        }
    }


    public String deleteBudget(Long budgetId) {
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(()-> new ResourceNotFoundException("Invalid  BudgetId , please provide valid BudgetId"));

        budgetRepository.delete(budget);

        return "Budget deleted successfully";
    }
}
