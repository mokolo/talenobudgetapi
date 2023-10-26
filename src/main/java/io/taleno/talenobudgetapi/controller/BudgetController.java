package io.taleno.talenobudgetapi.controller;

import io.taleno.talenobudgetapi.dto.BudgetDto;
import io.taleno.talenobudgetapi.service.impl.BudgetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/budgets")
@AllArgsConstructor
public class BudgetController {

    BudgetService budgetService;

    @PostMapping
    public ResponseEntity<BudgetDto> create(@RequestBody BudgetDto budgetDto){
        BudgetDto budgetDtoSaved = budgetService.save(budgetDto);
        return new ResponseEntity<>(budgetDtoSaved, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<BudgetDto> getOne(@PathVariable Long id){
        BudgetDto budgetDto = budgetService.getOne(id);
        return new ResponseEntity<>(budgetDto, HttpStatus.OK);
    }
}
