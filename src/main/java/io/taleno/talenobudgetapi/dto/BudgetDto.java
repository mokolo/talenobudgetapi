package io.taleno.talenobudgetapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetDto {
        private Long id;
        private Long userId;
        private Double targetAmount;
        private Double currentAmount;
        private Double periodicContributionAmount;
        private LocalDate startDate;
        private LocalDate endDate;
        private String strategy;

}


