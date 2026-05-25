package com.project.expenseTracker.dto.request;

import com.project.expenseTracker.enums.BudgetPeriod;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BudgetRequestDTO {
    @NotNull
    private Long categoryId;

    @NotNull
    private Long userId;

    @NotBlank
    @Size(max = 100)
    private String budgetTitle;

    @NotNull
    @Positive
    private Double budgetAmount;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

    private BudgetPeriod budgetPeriod;

    @FutureOrPresent
    private LocalDate endDate;

    private String notes;
}
