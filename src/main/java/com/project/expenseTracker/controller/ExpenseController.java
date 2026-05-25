//package com.project.expenseTracker.controller;
//
//import com.project.expenseTracker.dto.request.ExpenseRequestDTO;
//import com.project.expenseTracker.dto.response.ExpenseResponseDTO;
//import com.project.expenseTracker.exceptions.ResourceNotFoundException;
//import com.project.expenseTracker.service.ExpenseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/expense")
//public class ExpenseController {
//
//    @Autowired
//    private ExpenseService expenseService;
//
//    @PostMapping
//    public ResponseEntity<ExpenseResponseDTO> createExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO) {
//        try {
//            expenseService.createExpense(expenseRequestDTO);
//            return ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(expenseService.createExpense(expenseRequestDTO));
//        } catch (ResourceNotFoundException ex) {
//            ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("");
//        }
//    }
//
////    @GetMapping
////    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenses(){
////
//////        return ResponseEntity.ok(expenseService.getAllExpenses());
////    }
//}
