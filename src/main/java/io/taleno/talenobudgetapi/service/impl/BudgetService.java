package io.taleno.talenobudgetapi.service.impl;


import io.taleno.talenobudgetapi.dto.BudgetDto;
import io.taleno.talenobudgetapi.entity.Budget;
import io.taleno.talenobudgetapi.repository.BudgetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BudgetService implements io.taleno.talenobudgetapi.service.BudgetService {

    private BudgetRepository budgetRepository;
    private ModelMapper modelMapper;

    @Override
    public BudgetDto save(BudgetDto budgetDto) {
        Budget budget = modelMapper.map(budgetDto, Budget.class);
        Budget budgetSaved = budgetRepository.save(budget);
        return modelMapper.map(budgetSaved, BudgetDto.class);
    }

    @Override
    public BudgetDto getOne(Long id) {
      Budget budget=  budgetRepository.getReferenceById(id);
      return  modelMapper.map(budget, BudgetDto.class);
    }
}
