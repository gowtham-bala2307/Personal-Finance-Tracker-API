package com.gowtham.personalfinancetracker.service;

public class FinanceSummary {

    private Double totalIncome;
    private Double totalExpense;
    private Double taxAmount;
    private Double netProfitAfterTax;

    public FinanceSummary(Double totalIncome,
                          Double totalExpense,
                          Double taxAmount,
                          Double netProfitAfterTax) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.taxAmount = taxAmount;
        this.netProfitAfterTax = netProfitAfterTax;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public Double getNetProfitAfterTax() {
        return netProfitAfterTax;
    }
}


