package com.project.expenseTracker.dto.specificationInput.filerDto;

import com.project.expenseTracker.enums.FiltersOperation;
import lombok.Data;

@Data
public class FilterRequestDTO {
    private String column;
    private Object value;
    private FiltersOperation operation;
}
