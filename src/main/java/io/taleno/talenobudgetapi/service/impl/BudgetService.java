package io.taleno.talenobudgetapi.service.impl;


import io.taleno.talenobudgetapi.dto.BudgetDto;
import io.taleno.talenobudgetapi.dto.BudgetsUserDto;
import io.taleno.talenobudgetapi.entity.Budget;
import io.taleno.talenobudgetapi.entity.UserDto;
import io.taleno.talenobudgetapi.repository.BudgetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BudgetService implements io.taleno.talenobudgetapi.service.BudgetService {

    private BudgetRepository budgetRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;

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

    @Override
    public BudgetsUserDto getBudgetsForOneUser(Long userId) {
        List<Budget> budgets = budgetRepository.findByUserId(userId);
       List<BudgetDto> budgetDtos= budgets.stream()
                                            .map(budget -> modelMapper.map(budget, BudgetDto.class))
                                            .collect(Collectors.toList());
        UserDto userDto =  restTemplate.getForEntity("http://localhost:8081/api/users/" + userId,
                UserDto.class).getBody();
        BudgetsUserDto budgetsUserDto = new BudgetsUserDto(budgetDtos,userDto);
        return budgetsUserDto;
    }
}
