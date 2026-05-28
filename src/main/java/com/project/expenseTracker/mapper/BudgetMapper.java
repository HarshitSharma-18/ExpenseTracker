package com.project.expenseTracker.mapper;

import com.project.expenseTracker.dto.request.BudgetRequestDTO;
import com.project.expenseTracker.dto.response.BudgetResponseDTO;
import com.project.expenseTracker.entity.Budget;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BudgetMapper {

    public Budget requestDtoToEntity(BudgetRequestDTO budgetRequestDTO , Category category , User user){
        Budget budget = new Budget();

        budget.setBudgetTitle(budgetRequestDTO.getBudgetTitle());

        budget.setBudgetAmount(budgetRequestDTO.getBudgetAmount());

        budget.setStartDate(budgetRequestDTO.getStartDate());

        budget.setBudgetPeriod(budgetRequestDTO.getBudgetPeriod());

        budget.setEndDate(budgetRequestDTO.getEndDate());

        budget.setNotes(budgetRequestDTO.getNotes());

        budget.setCategory(category);

        budget.setUser(user);

        return budget;
    }

    public BudgetResponseDTO entityToResponseDto(Budget budget){
        BudgetResponseDTO budgetResponseDTO = new BudgetResponseDTO();

        budgetResponseDTO.setId(budget.getId());

        budgetResponseDTO.setCategoryTypeName(budget.getCategory().getCategoryName());

        budgetResponseDTO.setBudgetTitle(budget.getBudgetTitle());

        budgetResponseDTO.setBudgetAmount(budget.getBudgetAmount());

        budgetResponseDTO.setStartDate(budget.getStartDate());

        budgetResponseDTO.setBudgetPeriod(budget.getBudgetPeriod());

        budgetResponseDTO.setEndDate(budget.getEndDate());

        budgetResponseDTO.setNotes(budget.getNotes());

        return budgetResponseDTO;
    }

    public Budget updateEntityFromDto(BudgetRequestDTO budgetRequestDTO , Budget budget , Category category){

        if(budgetRequestDTO.getBudgetTitle() != null){
            budget.setBudgetTitle(budgetRequestDTO.getBudgetTitle());
        }

        if(budgetRequestDTO.getBudgetAmount() != null){
            budget.setBudgetAmount(budgetRequestDTO.getBudgetAmount());
        }

        if(budgetRequestDTO.getStartDate() != null){
            budget.setStartDate(budgetRequestDTO.getStartDate());
        }

        if(budgetRequestDTO.getBudgetPeriod() != null){
            budget.setBudgetPeriod(budgetRequestDTO.getBudgetPeriod());
        }

        if(budgetRequestDTO.getEndDate() != null){
            budget.setEndDate(budgetRequestDTO.getEndDate());
        }

        if(budgetRequestDTO.getNotes() != null){
            budget.setNotes(budgetRequestDTO.getNotes());
        }

        if(budgetRequestDTO.getCategoryId() != null){
            budget.setCategory(category);
        }

        return budget;
    }
}
