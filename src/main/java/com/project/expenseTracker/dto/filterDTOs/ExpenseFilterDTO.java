package com.project.expenseTracker.dto.filterDTOs;

import com.project.expenseTracker.enums.PaymentMethods;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExpenseFilterDTO {
    private Long userId;
    private Long expenseId;
    private Long categoryId;
    private LocalDate expenseDate;
    private Double amount;
    private String merchantName;
    private PaymentMethods paymentMethod;
}
