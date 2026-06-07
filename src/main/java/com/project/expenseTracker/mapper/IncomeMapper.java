package com.project.expenseTracker.mapper;
import com.project.expenseTracker.dto.request.putRequest.IncomeRequestDTO;
import com.project.expenseTracker.dto.request.updateRequest.IncomeUpdateRequestDTO;
import com.project.expenseTracker.dto.response.IncomeResponseDTO;
import com.project.expenseTracker.entity.Category;
import com.project.expenseTracker.entity.Currency;
import com.project.expenseTracker.entity.Income;
import com.project.expenseTracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper {

    public Income requestDtoToEntity(IncomeRequestDTO incomeRequestDTO , User user , Currency currency, Category category){
        Income income = new Income();

        income.setAmount(incomeRequestDTO.getAmount());
        income.setDescription(incomeRequestDTO.getDescription());

        income.setCategory(category);

        income.setCreditDate(incomeRequestDTO.getCreditDate());
        income.setSourceName(incomeRequestDTO.getSourceName());
        income.setPaymentMethods(incomeRequestDTO.getPaymentMethods());

        income.setCurrency(currency);

        income.setNotes(incomeRequestDTO.getNotes());
        income.setUser(user);

        return income;
    }

    public IncomeResponseDTO entityToResponseDto(Income income){
        IncomeResponseDTO incomeResponseDTO = new IncomeResponseDTO();

        incomeResponseDTO.setId(income.getId());

        incomeResponseDTO.setCategoryId(income.getCategory().getId());
        incomeResponseDTO.setCategoryName(income.getCategory().getCategoryName());
        incomeResponseDTO.setCategoryType(income.getCategory().getCategoryType());
        incomeResponseDTO.setAmount(income.getAmount());

        incomeResponseDTO.setCurrency(income.getCurrency());

        incomeResponseDTO.setDesc(income.getDescription());
        incomeResponseDTO.setCreditDate(income.getCreditDate());
        incomeResponseDTO.setSourceName(income.getSourceName());
        incomeResponseDTO.setPaymentMethod(income.getPaymentMethods());
        incomeResponseDTO.setNotes(income.getNotes());
        incomeResponseDTO.setCreatedDateTime(income.getCreatedAt());

        return incomeResponseDTO;
    }

    public Income updateIncome(IncomeUpdateRequestDTO incomeUpdateRequestDTO , Income income , Category category , Currency currency){
        if(incomeUpdateRequestDTO.getAmount() != null){
            income.setAmount(incomeUpdateRequestDTO.getAmount());
        }

        if(incomeUpdateRequestDTO.getCategoryId() != null){
            income.setCategory(category);
        }

        if(incomeUpdateRequestDTO.getDescription() != null){
            income.setDescription(incomeUpdateRequestDTO.getDescription());
        }

        if(incomeUpdateRequestDTO.getCreditDate() != null){
            income.setCreditDate(incomeUpdateRequestDTO.getCreditDate());
        }

        if(incomeUpdateRequestDTO.getSourceName() != null){
            income.setSourceName(incomeUpdateRequestDTO.getSourceName());
        }

        if(incomeUpdateRequestDTO.getPaymentMethods() != null){
            income.setPaymentMethods(incomeUpdateRequestDTO.getPaymentMethods());
        }

        if(incomeUpdateRequestDTO.getCurrencyId() != null){
            income.setCurrency(currency);
        }

        if(incomeUpdateRequestDTO.getNotes() != null){
            income.setNotes(incomeUpdateRequestDTO.getNotes());
        }

        return income;
    }
}
