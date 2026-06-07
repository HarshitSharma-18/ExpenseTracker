package com.project.expenseTracker.dto.request.putRequest;
import com.project.expenseTracker.enums.PaymentMethods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
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
    @Positive
    private Double amount;

    private String merchantName;

    @NotNull
    @PastOrPresent
    private LocalDate expenseDate;

    @NotNull
    private PaymentMethods paymentMethods;

    private Long currencyId;

    private String notes;
}
