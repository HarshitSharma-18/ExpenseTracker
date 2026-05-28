package com.project.expenseTracker.controller;

import com.project.expenseTracker.dto.request.ExpenseRequestDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.dto.response.ExpenseResponseDTO;
import com.project.expenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseService.createExpense(expenseRequestDTO));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ExpenseResponseDTO>> getExpenseBy(@RequestBody List_FilterRequestDTO listFilterRequestDTO){
        return ResponseEntity.ok(expenseService.getExpenseBy(listFilterRequestDTO));
    }

    @GetMapping("/getAllExpense")
    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO ,  Long userId){
        return ResponseEntity.ok(expenseService.updateExpense(userId ,expenseRequestDTO));
    }

    @DeleteMapping("delete/{expenseId}")
    public ResponseEntity<String> deleteExpense(Long expenseId){
        return  ResponseEntity.ok(expenseService.deleteExpense(expenseId));
    }

}
