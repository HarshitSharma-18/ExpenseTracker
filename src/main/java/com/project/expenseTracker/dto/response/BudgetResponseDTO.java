package com.project.expenseTracker.dto.response;
import com.project.expenseTracker.enums.BudgetPeriod;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BudgetResponseDTO {
    private Long id;

    private String categoryTypeName;

    private String budgetTitle;

    private Double budgetAmount;

    private LocalDate startDate;

    private BudgetPeriod budgetPeriod;

    private LocalDate endDate;

    private String notes;
}
