package com.gowtham.personalfinancetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gowtham.personalfinancetracker.entity.expense;
import com.gowtham.personalfinancetracker.service.expenseService;

@RestController
@RequestMapping("/api/expenses")
public class expenseController {

    @Autowired
    private expenseService expenseService;

    @PostMapping
    public expense createExpense(@RequestBody expense expense) {
        return expenseService.createExpense(expense);
    }

    @GetMapping
    public List<expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
}
