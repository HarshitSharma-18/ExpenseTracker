package com.project.expenseTracker.entity;
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

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Double amount;

    private String merchantName;

    @NotNull
    @Column(nullable = false)
    @PastOrPresent
    private LocalDate expenseDate;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private String notes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
