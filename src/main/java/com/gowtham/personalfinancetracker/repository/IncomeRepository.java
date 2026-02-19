package com.gowtham.personalfinancetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.gowtham.personalfinancetracker.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
	@Query("SELECT SUM(i.amount) FROM Income i WHERE i.user.id = :userId")
	Double getTotalIncomeByUser(@Param("userId") Long userId);

}
