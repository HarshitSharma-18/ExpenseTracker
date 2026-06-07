package com.project.expenseTracker.entity;

import com.project.expenseTracker.enums.CategoryTypes;
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
    @ManyToOne
    @JoinColumn(name = "column_id")
    private Category category;

    @NotNull
    @Column(nullable = false)
    @Positive
    private Double amount;

    private String description;

    @NotNull
    @Column(nullable = false)
    @PastOrPresent
    private LocalDate creditDate;

    @NotBlank
    @Column(nullable = false)
    private String sourceName;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryTypes categoryTypes;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @OneToOne
    @JoinColumn(name = "currency")
    private Currency currency;

    private String notes;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
        categoryTypes = INCOME;
    }
}
