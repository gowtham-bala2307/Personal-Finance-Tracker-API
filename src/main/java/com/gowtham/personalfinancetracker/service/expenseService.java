package com.gowtham.personalfinancetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowtham.personalfinancetracker.entity.expense;
import com.gowtham.personalfinancetracker.repository.expenseRepository;

@Service
public class expenseService {

    @Autowired
    private expenseRepository expenseRepository;

    public expense createExpense(expense expense) {
        return expenseRepository.save(expense);
    }

    public List<expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
