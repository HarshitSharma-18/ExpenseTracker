package com.project.expenseTracker.controller;

import com.project.expenseTracker.dto.request.putRequest.BudgetRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.BudgetUpdateRequestDTO;
import com.project.expenseTracker.dto.response.BudgetResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    private BudgetService budgetService;

    @PostMapping("/create")
    public ResponseEntity<BudgetResponseDTO> createBudget(@RequestBody BudgetRequestDTO budgetRequestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(budgetService.createBudget(budgetRequestDTO));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BudgetResponseDTO>> getBudgetBy(@RequestBody List_FilterRequestDTO listFilterRequestDTO){
        return ResponseEntity.ok(budgetService.getBudgetBy(listFilterRequestDTO));
    }

    @GetMapping("/getAllBudget")
    public ResponseEntity<List<BudgetResponseDTO>> getAllBudget(){
        return ResponseEntity.ok(budgetService.getAllBudget());
    }

    @PatchMapping("/{budgetId}")
    public ResponseEntity<BudgetResponseDTO> updateBudget(@PathVariable Long budgetId , @RequestBody BudgetUpdateRequestDTO budgetUpdateRequestDTO){
        return ResponseEntity.ok(budgetService.updateBudget(budgetId , budgetUpdateRequestDTO));
    }

    @DeleteMapping("/delete/{budgetId}")
    public ResponseEntity<String> deleteBudget(@PathVariable Long budgetId){
        return ResponseEntity
                .ok(budgetService.deleteBudget(budgetId));
    }
}
