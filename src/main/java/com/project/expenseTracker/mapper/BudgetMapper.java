package com.project.expenseTracker.mapper;

import com.project.expenseTracker.dto.request.putRequest.BudgetRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.BudgetUpdateRequestDTO;
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

        budgetResponseDTO.setCategoryId(budget.getCategory().getId());
        budgetResponseDTO.setCategoryName(budget.getCategory().getCategoryName());
        budgetResponseDTO.setCategoryType(budget.getCategory().getCategoryType());

        budgetResponseDTO.setBudgetTitle(budget.getBudgetTitle());

        budgetResponseDTO.setBudgetAmount(budget.getBudgetAmount());

        budgetResponseDTO.setStartDate(budget.getStartDate());

        budgetResponseDTO.setBudgetPeriod(budget.getBudgetPeriod());

        budgetResponseDTO.setEndDate(budget.getEndDate());

        budgetResponseDTO.setNotes(budget.getNotes());

        return budgetResponseDTO;
    }

    public Budget updateBudget(BudgetUpdateRequestDTO budgetUpdateRequestDTO , Budget budget , Category category){

        if(budgetUpdateRequestDTO.getBudgetTitle() != null){
            budget.setBudgetTitle(budgetUpdateRequestDTO.getBudgetTitle());
        }

        if(budgetUpdateRequestDTO.getBudgetAmount() != null){
            budget.setBudgetAmount(budgetUpdateRequestDTO.getBudgetAmount());
        }

        if(budgetUpdateRequestDTO.getStartDate() != null){
            budget.setStartDate(budgetUpdateRequestDTO.getStartDate());
        }

        if(budgetUpdateRequestDTO.getBudgetPeriod() != null){
            budget.setBudgetPeriod(budgetUpdateRequestDTO.getBudgetPeriod());
        }

        if(budgetUpdateRequestDTO.getEndDate() != null){
            budget.setEndDate(budgetUpdateRequestDTO.getEndDate());
        }

        if(budgetUpdateRequestDTO.getNotes() != null){
            budget.setNotes(budgetUpdateRequestDTO.getNotes());
        }

        if(budgetUpdateRequestDTO.getCategoryId() != null){
            budget.setCategory(category);
        }

        return budget;
    }
}
