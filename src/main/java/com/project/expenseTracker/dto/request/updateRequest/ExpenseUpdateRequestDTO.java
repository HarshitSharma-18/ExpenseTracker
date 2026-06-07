package com.project.expenseTracker.dto.request.updateRequest;
import com.project.expenseTracker.enums.PaymentMethods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseUpdateRequestDTO {
    private Long categoryId;
    private String description;
    @Positive
    private Double amount;
    private String merchantName;
    @PastOrPresent
    private LocalDate expenseDate;
    private PaymentMethods paymentMethods;
    private Long currencyId;
    private String notes;
}
