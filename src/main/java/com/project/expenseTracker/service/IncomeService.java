package com.project.expenseTracker.service;
import com.project.expenseTracker.dto.request.putRequest.IncomeRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.IncomeUpdateRequestDTO;
import com.project.expenseTracker.dto.response.IncomeResponseDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.entity.Income;
import com.project.expenseTracker.entity.User;
import com.project.expenseTracker.exceptions.ResourceNotFoundException;
import com.project.expenseTracker.mapper.IncomeMapper;
import com.project.expenseTracker.repository.CategoryRepository;
import com.project.expenseTracker.repository.CurrencyRepository;
import com.project.expenseTracker.repository.IncomeRepository;
import com.project.expenseTracker.repository.UserRepository;
import com.project.expenseTracker.specification.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    private CurrencyRepository currencyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public IncomeResponseDTO addIncome(IncomeRequestDTO incomeRequestDTO){

        //userID validation
        User user = userRepository.findById(incomeRequestDTO.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Invalid UserID , Please Provide valid UserId"));

        //currencyId validation
        Currency currency = currencyRepository.findById(incomeRequestDTO.getCurrencyId()).orElseThrow(()-> new ResourceNotFoundException("Currency Id is Invalid"));

        //categoryId validation
        Category category = categoryRepository.findById(incomeRequestDTO.getCategoryId()).orElseThrow(()->new ResourceNotFoundException("Invalid CategoryID"));

        //requestToEntity
        Income newIncome = incomeMapper.requestDtoToEntity(incomeRequestDTO , user , currency , category);

        //Fetching user's currency for byDefault
        if(incomeRequestDTO.getCurrencyId() == null){
            newIncome.setCurrency(user.getCurrency());
        }

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

    public IncomeResponseDTO updateIncome(Long incomeId , IncomeUpdateRequestDTO incomeUpdateRequestDTO){
        Income income = incomeRepository.findById(incomeId).orElseThrow(()-> new ResourceNotFoundException("Invalid IncomeId , Please Provide Valid IncomeId"));

        Currency currency = null;
        Category category = null;


        if(incomeUpdateRequestDTO.getCategoryId() != null){
            category = categoryRepository.findById(incomeUpdateRequestDTO.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("Invalid CategoryId"));
        }
        if(incomeUpdateRequestDTO.getCurrencyId() != null) {
            currency = currencyRepository.findById(incomeUpdateRequestDTO.getCurrencyId()).orElseThrow(() -> new ResourceNotFoundException("Invalid CurrencyId"));
        }

        Income updatedIncome = incomeMapper.updateIncome(incomeUpdateRequestDTO , income , category , currency);
        return incomeMapper.entityToResponseDto(updatedIncome);
    }

    public String deleteIncome(Long incomeId){
        Income income = incomeRepository.findById(incomeId).orElseThrow(()-> new ResourceNotFoundException("Invalid IncomeId , Please Provide Valid IncomeId"));

        incomeRepository.delete(income);

        return "Income Deleted Successfully";
    }
}
