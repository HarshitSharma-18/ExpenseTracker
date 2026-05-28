package com.project.expenseTracker.controller;

import com.project.expenseTracker.dto.request.IncomeRequestDTO;
import com.project.expenseTracker.dto.response.IncomeResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping("/newIncome")
    public ResponseEntity<IncomeResponseDTO> addIncome(@RequestBody IncomeRequestDTO incomeRequestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(incomeService.addIncome(incomeRequestDTO));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<IncomeResponseDTO>> getIncomeBy(@RequestBody List_FilterRequestDTO listFilterRequestDTO){
        return ResponseEntity.ok(incomeService.getIncomeBy(listFilterRequestDTO));
    }

    @GetMapping("/getAllIncome")
    public ResponseEntity<List<IncomeResponseDTO>> getAllIncome(){
        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    @GetMapping("/update/{incomeId}")
    public ResponseEntity<IncomeResponseDTO> updateIncome(@PathVariable Long incomeId , @RequestBody IncomeRequestDTO incomeRequestDTO){
        return ResponseEntity.ok(incomeService.updateIncome(incomeId , incomeRequestDTO));
    }

    @DeleteMapping("/delete/{incomeId}")
    public ResponseEntity<String> deleteIncome(@PathVariable Long incomeId){
        return ResponseEntity.ok(incomeService.deleteIncome(incomeId));
    }
}
