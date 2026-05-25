package com.project.expenseTracker.entity;
import com.project.expenseTracker.enums.Currency;
import com.project.expenseTracker.enums.PaymentMethods;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    @NotBlank
    private String description;

    @NotNull
    private Double amount;

    private String merchantName;

    @NotNull
    @PastOrPresent
    private LocalDate expenseDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @Enumerated(EnumType.STRING)
    private Currency currency = Currency.INR;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String notes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
