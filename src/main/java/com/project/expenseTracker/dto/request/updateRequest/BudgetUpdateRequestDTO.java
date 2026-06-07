package com.project.expenseTracker.dto.request.updateRequest;

import com.project.expenseTracker.enums.BudgetPeriod;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BudgetUpdateRequestDTO {
    private Long categoryId;
    @Size(max = 100)
    private String budgetTitle;
    @Positive
    private Double budgetAmount;
    @FutureOrPresent
    private LocalDate startDate;
    private BudgetPeriod budgetPeriod;
    @FutureOrPresent
    private LocalDate endDate;
    private String notes;
}
