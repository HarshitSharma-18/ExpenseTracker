package com.project.expenseTracker.dto.response;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.enums.CategoryTypes;
import com.project.expenseTracker.enums.PaymentMethods;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class IncomeResponseDTO {
    private Long id;

    private Long categoryId;
    private String categoryName;
    private CategoryTypes categoryType;

    private Double amount;
    private String desc;
    private LocalDate creditDate;
    private String sourceName;
    private PaymentMethods paymentMethod;

    private Currency currency;

    private String notes;
    private LocalDateTime createdDateTime;
}
