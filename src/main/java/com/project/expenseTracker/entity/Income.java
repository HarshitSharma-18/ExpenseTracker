package com.project.expenseTracker.entity;

import com.project.expenseTracker.enums.CategoryTypes;
import com.project.expenseTracker.enums.Currency;
import com.project.expenseTracker.enums.PaymentMethods;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.project.expenseTracker.enums.CategoryTypes.INCOME;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    @Enumerated(EnumType.STRING)
    private CategoryTypes categoryTypes;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @Enumerated(EnumType.STRING)
    private Currency currency = Currency.INR;

    private String notes;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void onCreate(){
        categoryTypes = INCOME;
    }
}
