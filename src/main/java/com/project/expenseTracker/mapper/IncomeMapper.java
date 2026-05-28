package com.project.expenseTracker.mapper;
import com.project.expenseTracker.dto.request.IncomeRequestDTO;
import com.project.expenseTracker.dto.response.IncomeResponseDTO;
import com.project.expenseTracker.entity.Income;
import com.project.expenseTracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper {

    public Income requestDtoToEntity(IncomeRequestDTO incomeRequestDTO , User user){
        Income income = new Income();

        income.setAmount(incomeRequestDTO.getAmount());
        income.setDescription(incomeRequestDTO.getDescription());
        income.setCreditDate(incomeRequestDTO.getCreditDate());
        income.setSourceName(incomeRequestDTO.getSourceName());
        income.setPaymentMethods(incomeRequestDTO.getPaymentMethods());
        income.setCurrency(incomeRequestDTO.getCurrency());
        income.setNotes(incomeRequestDTO.getNotes());
        income.setUser(user);

        return income;
    }

    public IncomeResponseDTO entityToResponseDto(Income income){
        IncomeResponseDTO incomeResponseDTO = new IncomeResponseDTO();

        incomeResponseDTO.setId(income.getId());

        incomeResponseDTO.setAmount(income.getAmount());

        incomeResponseDTO.setDesc(income.getDescription());

        incomeResponseDTO.setCreditDate(income.getCreditDate());

        incomeResponseDTO.setSourceName(income.getSourceName());

        incomeResponseDTO.setPaymentMethod(income.getPaymentMethods());

        incomeResponseDTO.setNotes(income.getNotes());

        incomeResponseDTO.setCreatedDateTime(income.getCreatedAt());

        return incomeResponseDTO;
    }

    public Income updateIncome(IncomeRequestDTO incomeRequestDTO , Income income){
        if(incomeRequestDTO.getAmount() != null){
            income.setAmount(incomeRequestDTO.getAmount());
        }

        if(incomeRequestDTO.getDescription() != null){
            income.setDescription(incomeRequestDTO.getDescription());
        }

        if(incomeRequestDTO.getCreditDate() != null){
            income.setCreditDate(incomeRequestDTO.getCreditDate());
        }

        if(incomeRequestDTO.getSourceName() != null){
            income.setSourceName(incomeRequestDTO.getSourceName());
        }

        if(incomeRequestDTO.getPaymentMethods() != null){
            income.setPaymentMethods(incomeRequestDTO.getPaymentMethods());
        }

        if(incomeRequestDTO.getCurrency() != null){
            income.setCurrency(incomeRequestDTO.getCurrency());
        }

        if(incomeRequestDTO.getNotes() != null){
            income.setNotes(incomeRequestDTO.getNotes());
        }

        return income;
    }
}
