package com.project.expenseTracker.dto.request.putRequest;

import com.project.expenseTracker.enums.PaymentMethods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long categoryId;

    @NotNull
    @Positive
    private Double amount;

    private String description;

    @NotNull
    @PastOrPresent
    private LocalDate creditDate;

    @NotBlank
    private String sourceName;

    @NotNull
    private PaymentMethods paymentMethods;

    private Long currencyId;

    @NotBlank
    private String notes;
}
