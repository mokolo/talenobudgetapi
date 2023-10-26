package io.taleno.talenobudgetapi.repository;

import io.taleno.talenobudgetapi.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
}
