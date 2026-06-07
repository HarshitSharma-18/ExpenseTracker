package com.project.expenseTracker.dto.request.updateRequest;
import com.project.expenseTracker.enums.PaymentMethods;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeUpdateRequestDTO {
    private Long categoryId;
    @Positive
    private Double amount;
    private String description;
    @PastOrPresent
    private LocalDate creditDate;
    private String sourceName;
    private PaymentMethods paymentMethods;
    private Long currencyId;
    private String notes;
}
