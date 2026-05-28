package com.project.expenseTracker.service;
import com.project.expenseTracker.dto.request.IncomeRequestDTO;
import com.project.expenseTracker.dto.response.IncomeResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.entity.Income;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.IncomeMapper;
import com.project.expenseTracker.repository.IncomeRepository;
import com.project.expenseTracker.repository.UserRepository;
import com.project.expenseTracker.specification.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    private UserRepository userRepository;

    public IncomeResponseDTO addIncome(IncomeRequestDTO incomeRequestDTO){
        User user = userRepository.findById(incomeRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Invalid UserID , Please Provide valid UserId"));
        Income newIncome = incomeMapper.requestDtoToEntity(incomeRequestDTO , user);

        incomeRepository.save(newIncome);

        return incomeMapper.entityToResponseDto(newIncome);
    }

    public List<IncomeResponseDTO> getIncomeBy(List_FilterRequestDTO listFilterRequestDTO){
        Specification<Income> specification = Specifications.getSpecification(listFilterRequestDTO);

        List<Income> incomeList = incomeRepository.findAll(specification);

        List<IncomeResponseDTO> incomeResponseDTOList = new ArrayList<>();
        incomeList.forEach(income -> {
            incomeResponseDTOList.add(incomeMapper.entityToResponseDto(income));
        });

        return incomeResponseDTOList;
    }

    public List<IncomeResponseDTO> getAllIncome(){
        List<Income> incomeList = incomeRepository.findAll();

        List<IncomeResponseDTO> incomeResponseDTOList = new ArrayList<>();


        incomeList.forEach(income -> {
            incomeResponseDTOList.add(incomeMapper.entityToResponseDto(income));
        });

        return incomeResponseDTOList;
    }

    public IncomeResponseDTO updateIncome(Long incomeId , IncomeRequestDTO incomeRequestDTO){
        Income income = incomeRepository.findById(incomeId).orElseThrow(()-> new ResourceNotFoundException("Invalid IncomeId , Please Provide Valid IncomeId"));

        Income updatedIncome = incomeMapper.updateIncome(incomeRequestDTO , income);

        return incomeMapper.entityToResponseDto(updatedIncome);
    }

    public String deleteIncome(Long incomeId){
        Income income = incomeRepository.findById(incomeId).orElseThrow(()-> new ResourceNotFoundException("Invalid IncomeId , Please Provide Valid IncomeId"));

        incomeRepository.delete(income);

        return "Income Deleted Successfully";
    }
}
