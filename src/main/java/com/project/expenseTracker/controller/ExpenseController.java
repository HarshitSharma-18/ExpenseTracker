package com.project.expenseTracker.controller;

import com.project.expenseTracker.dto.request.putRequest.ExpenseRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.ExpenseUpdateRequestDTO;
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

    @PostMapping
    public ResponseEntity<ExpenseResponseDTO> createExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseService.createExpense(expenseRequestDTO));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ExpenseResponseDTO>> getExpenseBy(@RequestBody List_FilterRequestDTO listFilterRequestDTO){
        return ResponseEntity.ok(expenseService.getExpenseBy(listFilterRequestDTO));
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @PatchMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@PathVariable Long expenseId ,@RequestBody ExpenseUpdateRequestDTO expenseUpdateRequestDTO){
        return ResponseEntity.ok(expenseService.updateExpense(expenseId , expenseUpdateRequestDTO));
    }

    @DeleteMapping("delete/{expenseId}")
    public ResponseEntity<String> deleteExpense(Long expenseId){
        return  ResponseEntity
                .ok(expenseService.deleteExpense(expenseId));
    }

}
