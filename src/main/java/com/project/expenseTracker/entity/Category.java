package com.project.expenseTracker.entity;

import com.project.expenseTracker.enums.CategoryTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryTypes categoryType;

    @NotBlank
    @Column(nullable = false)
    private String categoryName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
