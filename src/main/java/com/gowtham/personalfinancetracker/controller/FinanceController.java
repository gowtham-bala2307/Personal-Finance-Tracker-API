package com.gowtham.personalfinancetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gowtham.personalfinancetracker.service.FinanceService;
import com.gowtham.personalfinancetracker.service.FinanceSummary;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping("/summary/{userId}")
    public FinanceSummary getSummary(@PathVariable Long userId) {
        return financeService.getFinancialSummary(userId);
    }
}
