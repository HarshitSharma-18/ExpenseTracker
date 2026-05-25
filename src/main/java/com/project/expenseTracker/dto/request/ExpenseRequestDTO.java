package com.project.expenseTracker.dto.request;
import com.project.expenseTracker.enums.Currency;
import com.project.expenseTracker.enums.PaymentMethods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long categoryId;

    @NotBlank
    private String description;

    @NotNull
    private Double amount;

    private String merchantName;

    @NotNull
    private LocalDate expenseDate;

    @NotNull
    private PaymentMethods paymentMethods;

    private Currency currency = Currency.INR;

    private String notes;
}
