package com.gowtham.personalfinancetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import com.gowtham.personalfinancetracker.entity.expense;

public interface expenseRepository extends JpaRepository<expense, Long> {
	@Query("SELECT SUM(e.amount) FROM Expense e WHERE e.createdBy.id = :userId")
	Double getTotalExpenseByUser(@Param("userId") Long userId);


}
