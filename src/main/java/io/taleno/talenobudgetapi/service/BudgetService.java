package io.taleno.talenobudgetapi.service;

import io.taleno.talenobudgetapi.dto.BudgetDto;

public interface BudgetService  {

    public BudgetDto save(BudgetDto budgetDto);
    public BudgetDto getOne (Long id);
}
