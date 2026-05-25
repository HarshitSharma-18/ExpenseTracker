package com.project.expenseTracker.entity;
import com.project.expenseTracker.enums.BudgetPeriod;
import com.project.expenseTracker.enums.CategoryTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"user_id" , "category_id"}
                )
        }
)
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String budgetTitle;

    @NotNull
    @Positive
    private Double budgetAmount;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private BudgetPeriod budgetPeriod;

    @FutureOrPresent
    private LocalDate endDate;

    private String notes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
