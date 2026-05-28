package com.project.expenseTracker.specification;

import com.project.expenseTracker.dto.specificationInput.filerDto.FilterRequestDTO;
import com.project.expenseTracker.dto.specificationInput.filterRequestDto.List_FilterRequestDTO;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class Specifications {

    public static <T> Specification<T> getSpecification(List_FilterRequestDTO List_FilterRequestDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            for(FilterRequestDTO FilterRequestDTO : List_FilterRequestDTO.getListOfFilters()) {

                switch (FilterRequestDTO.getOperation()){
                    case EQUALS:
                        predicateList.add(criteriaBuilder.equal(root.get(FilterRequestDTO.getColumn()),
                                FilterRequestDTO.getValue()
                                )
                        );
                        break;

                    case GREATER_THAN:
                        predicateList.add(
                                criteriaBuilder.greaterThan(root.get(FilterRequestDTO.getColumn()),
                                        Double.parseDouble(FilterRequestDTO
                                        .getValue()
                                        .toString()
                                        )
                                )
                        );
                        break;

                    case LESSER_THAN:
                        predicateList.add(
                                criteriaBuilder.lessThan(root.get(FilterRequestDTO.getColumn()),
                                        Double.parseDouble(FilterRequestDTO
                                                .getValue()
                                                .toString()
                                        )
                                )
                        );
                        break;

                    case LIKE:
                        predicateList.add(
                                criteriaBuilder.like(root.get(FilterRequestDTO.getColumn()),
                                        "%" + FilterRequestDTO.getValue() + "%"
                                )
                        );
                        break;
                }
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }
}
