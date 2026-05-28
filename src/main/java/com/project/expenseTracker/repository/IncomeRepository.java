package com.project.expenseTracker.repository;

import com.project.expenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IncomeRepository extends JpaRepository<Income, Long> , JpaSpecificationExecutor<Income> {
}
