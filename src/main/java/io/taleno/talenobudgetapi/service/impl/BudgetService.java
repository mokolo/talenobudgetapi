package io.taleno.talenobudgetapi.service.impl;


import io.taleno.talenobudgetapi.dto.BudgetDto;
import io.taleno.talenobudgetapi.dto.BudgetsUserDto;
import io.taleno.talenobudgetapi.entity.Budget;
import io.taleno.talenobudgetapi.entity.UserDto;
import io.taleno.talenobudgetapi.repository.BudgetRepository;
import io.taleno.talenobudgetapi.service.ApiClient;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BudgetService implements io.taleno.talenobudgetapi.service.BudgetService {

    private BudgetRepository budgetRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;
    private WebClient webClient;
    private ApiClient feignclient;
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

    public BudgetsUserDto getBudgetsForOneUserv2(Long userId){
        List<Budget> budgets = budgetRepository.findByUserId(userId);
        List<BudgetDto> budgetDtos= budgets.stream()
                .map(budget -> modelMapper.map(budget, BudgetDto.class))
                .collect(Collectors.toList());
        UserDto userDto = webClient.get().uri("http://localhost:8081/api/users/" + userId)
                .retrieve().
                bodyToMono(UserDto.class).
                block();
        BudgetsUserDto budgetsUserDto = new BudgetsUserDto(budgetDtos,userDto);
        return budgetsUserDto;
    }

    public BudgetsUserDto getBudgetsForOneUserv3(Long userId){
        List<Budget> budgets = budgetRepository.findByUserId(userId);
        List<BudgetDto> budgetDtos= budgets.stream()
                .map(budget -> modelMapper.map(budget, BudgetDto.class))
                .collect(Collectors.toList());
        UserDto userDto = feignclient.get(userId);
        BudgetsUserDto budgetsUserDto = new BudgetsUserDto(budgetDtos,userDto);
        return budgetsUserDto;
    }

}
