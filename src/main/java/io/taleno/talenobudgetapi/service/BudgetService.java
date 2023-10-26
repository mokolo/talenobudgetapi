package io.taleno.talenobudgetapi.service;

import io.taleno.talenobudgetapi.dto.BudgetDto;
import io.taleno.talenobudgetapi.dto.BudgetsUserDto;
import io.taleno.talenobudgetapi.entity.UserDto;

public interface BudgetService  {

    public BudgetDto save(BudgetDto budgetDto);
    public BudgetDto getOne (Long id);
    public BudgetsUserDto getBudgetsForOneUser(Long id);
    public BudgetsUserDto getBudgetsForOneUserv2(Long id);

}
