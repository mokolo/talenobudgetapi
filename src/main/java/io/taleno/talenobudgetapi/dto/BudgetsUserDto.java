package io.taleno.talenobudgetapi.dto;

import io.taleno.talenobudgetapi.entity.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetsUserDto {
    private List<BudgetDto> budgets;
    private UserDto user ;
}
