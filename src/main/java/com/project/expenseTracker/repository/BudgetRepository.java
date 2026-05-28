package com.project.expenseTracker.repository;

import com.project.expenseTracker.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BudgetRepository extends JpaRepository<Budget , Long> , JpaSpecificationExecutor<Budget> {
}
