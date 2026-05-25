package com.project.expenseTracker.controller;

import com.project.expenseTracker.dto.request.ExpenseRequestDTO;
import com.project.expenseTracker.dto.response.ExpenseResponseDTO;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
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

    @GetMapping("/getAllExpense")
    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

//    @GetMapping("/getUserByExpenseId/{expenseId}")
//    public ResponseEntity<ExpenseResponseDTO> getExpenseByExpenseId(Long expenseId){
//        return ResponseEntity.ok(expenseService.getExpenseByExpenseId);
//    }
//
//    @GetMapping("/getAllExpenseByUserId/{userId}")
//    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenseByUserId(){
//        return ResponseEntity.ok(expenseService.getAllExpenseByUserId);
//    }

    @PutMapping("/updateExpense/{userId}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO ,  Long userId){
        return ResponseEntity.ok(expenseService.updateExpense(userId ,expenseRequestDTO));
    }

//    @DeleteMapping("deleteByUserId/{userId}")
//    public ResponseEntity<String> deleteExpense(Long userId){
//        return  ResponseEntity.ok(expenseService.deleteExpense(userId));
//    }

}
