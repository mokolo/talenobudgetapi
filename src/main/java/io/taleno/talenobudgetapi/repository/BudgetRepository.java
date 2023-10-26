package io.taleno.talenobudgetapi.repository;

import io.taleno.talenobudgetapi.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget,Long> {

    public List<Budget> findByUserId(Long id);
}
