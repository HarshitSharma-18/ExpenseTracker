package com.project.expenseTracker.dto.response;
import com.project.expenseTracker.enums.CategoryTypes;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.enums.PaymentMethods;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExpenseResponseDTO {
    private Long id;

    private Long categoryId;
    private String categoryName;
    private CategoryTypes categoryType;

    private String description;
    private Double amount;
    private String merchantName;
    private PaymentMethods paymentMethod;

    private Currency currency;

    private LocalDate transactionDate;
    private LocalDateTime recordDateAndTime;
    private String notes;
}
