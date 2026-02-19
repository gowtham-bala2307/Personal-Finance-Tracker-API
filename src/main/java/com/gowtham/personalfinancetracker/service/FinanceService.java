package com.gowtham.personalfinancetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowtham.personalfinancetracker.repository.expenseRepository;
import com.gowtham.personalfinancetracker.repository.IncomeRepository;
import com.gowtham.personalfinancetracker.repository.UserRepository;

@Service
public class FinanceService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private expenseRepository expenseRepository;
    
    @Autowired
    private UserRepository userRepository;
     
    public FinanceSummary getFinancialSummary(Long userId) {

        Double totalIncome = incomeRepository.getTotalIncomeByUser(userId);
        Double totalExpense = expenseRepository.getTotalExpenseByUser(userId);

        if (totalIncome == null) totalIncome = 0.0;
        if (totalExpense == null) totalExpense = 0.0;

        Double netBeforeTax = totalIncome - totalExpense;

        Double taxPercentage = userRepository.findById(userId)
                .map(user -> user.getTaxPercentage())
                .orElse(0.0);

        if (taxPercentage == null) taxPercentage = 0.0;

        Double taxAmount = (totalIncome * taxPercentage) / 100;

        Double netAfterTax = netBeforeTax - taxAmount;

        return new FinanceSummary(totalIncome, totalExpense, taxAmount, netAfterTax);
    }

   
}
