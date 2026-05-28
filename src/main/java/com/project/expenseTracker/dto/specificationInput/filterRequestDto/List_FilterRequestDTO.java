package com.project.expenseTracker.dto.specificationInput.filterRequestDto;
import com.project.expenseTracker.dto.specificationInput.filerDto.FilterRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class List_FilterRequestDTO {
    private List<FilterRequestDTO> listOfFilters;
}
